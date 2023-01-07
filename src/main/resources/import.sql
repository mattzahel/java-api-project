-- -- https://gizmodo.com/salary-transparency-big-tech-apple-meta-tesla-1849957910
INSERT INTO news (id, title, content, author, date) VALUES (1, 'California Pay Transparency Reveals Big Tech Salaries', 'California’s salary transparency law has officially gone into effect as of January 1, forcing companies to unveil the wages they pay to their workers. As such, the curtain is being pulled on the mystery behind the cash flowing through some of Silicon Valley’s…', 'Kevin Hurler', '2023-01-01')
--
-- -- https://www.cnn.com/2023/01/06/business/southwest-meltdown-cost/index.html
INSERT INTO news (id, title, content, author, date) VALUES (2, 'Southwest meltdown may cost the airline up to $825 million - CNN', 'The cost of the service meltdown at Southwest Airlines over the year-end holidays cost the airline nearly $1 billion and will cause the company to report a loss rather than a profit in the fourth quarter, the airline said in a filing on Friday.', 'Chris Isidore', '2023-01-05')
--
-- -- https://www.cnbc.com/2023/01/06/kuo-apple-will-announce-its-vr-headset-this-spring-at-the-earliest.html
INSERT INTO news (id, title, content, author, date) VALUES (3, 'Apple’s mixed-reality headset could be announced as soon as this spring, top analyst says - CNBC', 'Apple’s widely expected mixed-reality headset won’t be announced until spring 2023, top analyst Ming-Chi Kuo said, after delays.', 'Rohan Goswami', '2023-01-06')

ALTER SEQUENCE news_seq INCREMENT BY 52;
SELECT next value for news_seq;