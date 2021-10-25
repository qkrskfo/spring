UPDATE MEMBER
SET NAME       = ?,
    PASSWORD   = ?,
    PHONE      = ?,
    BIRTH_DATE = ?
WHERE ID = ?;


SELECT m.MOVIE_NO,
       TITLE,
       POSTER_IMAGE,
       s.SCREEN_NO,
       SCREEN_NAME,
       startDate,
       endDate
FROM movie                          m
JOIN (SELECT MOVIE_NO, SCREEN_NO, MIN(START_DATE) AS startDate, MAX(END_DATE) AS endDate
      FROM PERIOD
      GROUP BY MOVIE_NO, SCREEN_NO) p
     ON m.MOVIE_NO = p.MOVIE_NO
JOIN SCREEN                         s
     ON p.SCREEN_NO = s.SCREEN_NO
WHERE m.MOVIE_NO = 2;


UPDATE TICKET
SET TICKET_STATUS = 0
WHERE TICKET_NO = ?;

SELECT * FROM TICKET;