CREATE TABLE projects
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying
);

CREATE TABLE jobs
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  status character varying(255),
  project_id INT,
  FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE steps
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  clazz character varying(255) NOT NULL,
  step_order integer,
  job_id INT,
  FOREIGN KEY (job_id) REFERENCES jobs(id)
);

CREATE TABLE step_configurations
(
  id serial PRIMARY KEY,
  name character varying(255) NOT NULL,
  value character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  step_id INT,
  FOREIGN KEY (step_id) REFERENCES steps(id)
);

--DROP all tables
--DROP TABLE step_configurations;
--DROP TABLE steps;
--DROP TABLE jobs;
--DROP TABLE projects;


-- DATA
 --Project
INSERT INTO projects (id ,name, description) VALUES (1, 'ROZETKA', 'project for retrieving data from rozetka');
INSERT INTO projects (id ,name, description) VALUES (2, 'Deshevshe', 'project for retrieving data from rozetka');

 --Job
INSERT INTO jobs (id ,name, status, project_id) VALUES (1, 'Parse main page', 'INACTIVE', 1);
INSERT INTO jobs (id ,name, status, project_id) VALUES (2, 'Get categories', 'INACTIVE', 2);

--steps
INSERT INTO steps (id, name, description, clazz, step_order, job_id)
VALUES (1, 'Get main page', '...', 'app.parser.step.processors.GetPage', 0, 1);
INSERT INTO steps (id, name, description, clazz, step_order, job_id)
VALUES (2, 'Iterate through categories', '...', 'app.parser.step.processors.ElementIterator', 1, 1);


--steps configuration
INSERT INTO step_configurations (name, value, description, step_id) VALUES ('SELECTOR', 'li[name=m-main-i]', 'selector iterate on', 2);
INSERT INTO step_configurations (name, value, description, step_id) VALUES ('ACTION', 'ECHO', 'iterate action', 2)