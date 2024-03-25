-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서 
-- 자동차 종류가 '트럭'인 자동차의 대여 기록에 대해서 
-- 대여 기록 별로 대여 금액(컬럼명: FEE)을 구하여 대여 기록 ID와 대여 금액 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 대여 기록 ID를 기준으로 내림차순 정렬해주세요.


select T.history_id, 
    case
        when p.discount_rate is null 
            then truncate((T.daily_fee * (datediff(T.end_date, T.start_date) + 1)), -1)
        when p.discount_rate is not null 
            then truncate(T.daily_fee * (1 - p.discount_rate / 100) * (datediff(end_date, start_date) + 1), -1)
    end as `fee`
  from CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
  right join (
        select c.car_id, c.car_type, c.daily_fee, h.history_id, h.start_date, h.end_date,
            case 
                when datediff(end_date, start_date) + 1 >= 90 then '90일 이상'
                when datediff(end_date, start_date) + 1 >= 30 then '30일 이상'
                when datediff(end_date, start_date) + 1 >= 7 then '7일 이상'
                else '7일 미만'
            end as `duration_type`
          from CAR_RENTAL_COMPANY_CAR as c
          join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
            on c.car_id = h.car_id
        ) as T
    on p.car_type = T.car_type and p.duration_type = T.duration_type
 where T.car_type = '트럭'
 group by T.history_id
 order by `fee` desc, T.history_id desc