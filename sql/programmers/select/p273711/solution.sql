# 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의
# 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요.
# 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요

select Child.ITEM_ID, Child.ITEM_NAME, Child.RARITY, PARENT.RARITY
  from ITEM_INFO as PARENT
  join ITEM_TREE as IT on IT.PARENT_ITEM_ID = PARENT.ITEM_ID
-- 한번더 ITEM_INFO 테이블과 join을 해준다.
  join ITEM_INFO as Child on IT.ITEM_ID = Child.ITEM_ID
 where PARENT.RARITY = 'RARE'
 order by Child.ITEM_ID desc