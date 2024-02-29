-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서 
-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서 
-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.

# select cc.car_id, cc.car_type, floor((cc.daily_fee * 30) * (1 - dp.discount_rate / 100)) as `dc_fee`, dp.duration_type, dp.discount_rate
#   from CAR_RENTAL_COMPANY_CAR as cc
#   join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as dp
#     on cc.car_type = dp.car_type
#  where (cc.car_type = '세단' or cc.car_type = 'SUV') and dp.duration_type = '30일 이상'

select distinct A.car_id, A.car_type, A.`dc_fee` as `fee`
  from (select cc.car_id, cc.car_type, floor((cc.daily_fee * 30) * (1 - dp.discount_rate / 100)) as `dc_fee`
          from CAR_RENTAL_COMPANY_CAR as cc
          join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as dp
            on cc.car_type = dp.car_type
         where (cc.car_type = '세단' or cc.car_type = 'SUV') and dp.duration_type = '30일 이상'
        ) as A
  join CAR_RENTAL_COMPANY_RENTAL_HISTORY as rh
    on A.car_id = rh.car_id
 where (A.`dc_fee` >= 500000 and A.`dc_fee` <= 2000000) 
   and A.car_id not in (select car_id 
                        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                       where '2022-11-01' between start_date and end_date 
                          or '2022-11-31' between start_date and end_date
                          or start_date between '2022-11-01' and '2022-11-31'
                          or end_date between '2022-11-01' and '2022-11-31')
 order by `fee` desc, A.car_type asc, A.car_id desc