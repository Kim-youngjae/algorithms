-- USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 
-- 중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성해주세요.
-- 이때, 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고, 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력해주세요.
-- 결과는 회원 ID를 기준으로 내림차순 정렬해주세요.

select distinct u.user_id, u.nickname, 
    concat(u.city, ' ', u.street_address1, ' ', u.street_address2) as `전체주소`, 
    concat(substr(u.tlno, 1, 3), '-',substr(u.tlno, 4, 4),'-',substr(u.tlno, 8, 4) ) as `전화번호`
  from used_goods_board as b
  join used_goods_user as u
    on u.user_id = b.writer_id
 group by b.writer_id having count(b.writer_id) >= 3
 order by u.user_id desc 