CREATE TABLE steps
(
  id serial NOT NULL,
  name character varying(255) NOT NULL,
  description character varying(500) DEFAULT '...'::character varying,
  clazz character varying(255) NOT NULL,
  step_order integer,
  CONSTRAINT steps_pkey PRIMARY KEY (id)
)