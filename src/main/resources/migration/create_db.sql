CREATE TABLE parse_job
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  status character varying(255)
);

CREATE TABLE steps
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  clazz character varying(255) NOT NULL,
  step_order integer,
  parse_job_id INT,
  FOREIGN KEY (parse_job_id) REFERENCES parse_job(id)
);

CREATE TABLE steps_configuration
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  value character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  step_id INT,
  FOREIGN KEY (step_id) REFERENCES steps(id)
);

--DROP all tables
DROP TABLE steps_configuration;
DROP TABLE steps;
DROP TABLE parse_job;


-- DATA
 --Job
INSERT INTO parse_job (id ,name, status) VALUES (1, 'Parse ROZETKA', 'INACTIVE');

--steps
INSERT INTO steps (id, name, description, clazz, step_order, parse_job_id)
VALUES (1, 'Get main page', '...', 'app.parser.step.processors.GetPage', 0, 1);
INSERT INTO steps (id, name, description, clazz, step_order, parse_job_id)
VALUES (2, 'Iterate through categories', '...', 'app.parser.step.processors.ElementIterator', 1, 1);


--steps configuration
INSERT INTO steps_configuration (name, value, description, step_id) VALUES ('SELECTOR', 'li[name=m-main-i]', 'selector iterate on', 2);
INSERT INTO steps_configuration (name, value, description, step_id) VALUES ('ACTION', 'ECHO', 'iterate action', 2)