CREATE TABLE IF NOT EXISTS  roles (
    id int PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    is_verified BOOLEAN DEFAULT false,
    code VARCHAR(255),
    role_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);


CREATE TABLE IF NOT EXISTS "configurations" (
	"id" BIGINT NOT NULL,
	"enable_blog" BOOLEAN NULL DEFAULT true,
	"enable_projects" BOOLEAN NULL DEFAULT true,
	"logo_url" VARCHAR(255) NULL DEFAULT NULL,
	"primary_color" VARCHAR(255) NULL DEFAULT NULL,
	"secondary_color" VARCHAR(255) NULL DEFAULT NULL,
	"site_name" VARCHAR NULL DEFAULT 'Portfólio João Matheus',
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "languages" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);


CREATE TABLE IF NOT EXISTS "frameworks" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"language_id" BIGINT NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "fkqy32p17da1r14yq2ir757adnu" FOREIGN KEY ("language_id") REFERENCES "languages" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS "post_categories" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);


CREATE TABLE IF NOT EXISTS "posts" (
	"id" SERIAL NOT NULL,
	"content" VARCHAR(100000) NULL DEFAULT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"slug" VARCHAR(255) NULL DEFAULT NULL,
	"title" VARCHAR(255) NULL DEFAULT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	"category_id" BIGINT NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "fkgj3uskfyllrt5ip3ag8xc8lfx" FOREIGN KEY ("category_id") REFERENCES "post_categories" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS "post_components" (
	"id" SERIAL NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"slug" VARCHAR(255) NULL DEFAULT NULL,
	"type" VARCHAR(255) NULL DEFAULT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "post_components_type_check" CHECK ((((type)::text = ANY ((ARRAY['PARAGRAPH'::character varying, 'IMAGE'::character varying, 'IMAGE_WITH_LEGEND'::character varying, 'CODE'::character varying])::text[]))))
);


CREATE TABLE IF NOT EXISTS "projects" (
	"id" SERIAL NOT NULL,
	"asset_link" VARCHAR(255) NULL DEFAULT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"description" VARCHAR(20000) NULL DEFAULT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"slug" VARCHAR(255) NULL DEFAULT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "tags" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "project_tag" (
	"project_id" BIGINT NOT NULL,
	"tag_id" BIGINT NOT NULL,
	CONSTRAINT "fk7arll7vppdy1j61xrux7nyy11" FOREIGN KEY ("project_id") REFERENCES "projects" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "fktdpca6u6cxadjbie0iyuyt324" FOREIGN KEY ("tag_id") REFERENCES "tags" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);
