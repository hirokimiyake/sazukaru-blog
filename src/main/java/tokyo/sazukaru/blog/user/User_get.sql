/*
userId = $1
*/
SELECT U.*
FROM M_USER U
WHERE U.USER_ID = /*userId*/
AND U.DEL_KBN = '01'
