INSERT INTO article(title, content) VALUES('1번', '1111');
INSERT INTO article(title, content) VALUES('2번', '2222');
INSERT INTO article(title, content) VALUES('3번', '3333');
INSERT INTO article(title, content) VALUES('4번', '4444');
INSERT INTO article(title, content) VALUES('5번', '5555');
INSERT INTO article(title, content) VALUES('6번', '6666');

-- 4댓글
INSERT INTO comment(article_id, nickname, body) VALUES(4, '4-1', '4-14-1');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '4-2', '4-24-2');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '4-3', '4-34-3');

-- 5댓글
INSERT INTO comment(article_id, nickname, body) VALUES(5, '5-1', '5-15-1');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '5-2', '5-25-2');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '5-3', '5-35-3');

-- 6댓글
INSERT INTO comment(article_id, nickname, body) VALUES(6, '6-1', '6-16-1');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '6-2', '6-26-2');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '6-3', '6-36-3');