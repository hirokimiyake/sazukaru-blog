/*
mailAddress = $1
password = $2
*/
SELECT U.*
FROM M_USER U
WHERE U.MAIL_ADDRESS = /*mailAddress*/
AND U.PASSWORD = /*password*/
AND U.DEL_KBN = '01'
