--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-02-12 16:01:33 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE ordinap;
--
-- TOC entry 2244 (class 1262 OID 17987)
-- Name: ordinap; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE ordinap WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'tr_TR.UTF-8' LC_CTYPE = 'tr_TR.UTF-8';


ALTER DATABASE ordinap OWNER TO postgres;

\connect ordinap

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12397)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 18245)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE comment (
    id bigint NOT NULL,
    "post_id" integer,
    "user_id" integer,
    "comment_description" character varying(255),
    "comment_image_path" character varying(255),
    "is_answer" boolean,
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE comment OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 18243)
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comment_id_seq OWNER TO postgres;

--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 197
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE comment_id_seq OWNED BY comment.id;


--
-- TOC entry 182 (class 1259 OID 18117)
-- Name: contact_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "contact_type" (
    id bigint NOT NULL,
    "contact_name" character varying(100),
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE "contact_type" OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 18115)
-- Name: contact_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "contact_type_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "contact_type_id_seq" OWNER TO postgres;

--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 181
-- Name: contact_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "contact_type_id_seq" OWNED BY "contact_type".id;


--
-- TOC entry 188 (class 1259 OID 18176)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE courses (
    id bigint NOT NULL,
    name character varying(255),
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE courses OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 18174)
-- Name: courses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE courses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE courses_id_seq OWNER TO postgres;

--
-- TOC entry 2250 (class 0 OID 0)
-- Dependencies: 187
-- Name: courses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE courses_id_seq OWNED BY courses.id;


--
-- TOC entry 192 (class 1259 OID 18198)
-- Name: exam_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "exam_type" (
    id bigint NOT NULL,
    "exam_name" character varying(255),
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE "exam_type" OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 18196)
-- Name: exam_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "exam_type_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "exam_type_id_seq" OWNER TO postgres;

--
-- TOC entry 2251 (class 0 OID 0)
-- Dependencies: 191
-- Name: exam_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "exam_type_id_seq" OWNED BY "exam_type".id;


--
-- TOC entry 196 (class 1259 OID 18224)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE post (
    id bigint NOT NULL,
    "user_id" integer,
    "unite_id" integer,
    "post_description" character varying(255),
    "post_imagePath" character varying(255) NOT NULL,
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE post OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 18222)
-- Name: post_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE post_id_seq OWNER TO postgres;

--
-- TOC entry 2252 (class 0 OID 0)
-- Dependencies: 195
-- Name: post_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE post_id_seq OWNED BY post.id;


--
-- TOC entry 186 (class 1259 OID 18136)
-- Name: profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE profile (
    id bigint NOT NULL,
    "user_id" integer,
    "contact_type_id" integer,
    value character varying(255),
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE profile OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 18134)
-- Name: profile_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE profile_id_seq OWNER TO postgres;

--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 185
-- Name: profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE profile_id_seq OWNED BY profile.id;


--
-- TOC entry 194 (class 1259 OID 18206)
-- Name: unite_to_exam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "unite_to_exam" (
    id bigint NOT NULL,
    "exam_type_id" integer,
    "unite_id" integer,
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE "unite_to_exam" OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 18204)
-- Name: unite_to_exam_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "unite_to_exam_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "unite_to_exam_id_seq" OWNER TO postgres;

--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 193
-- Name: unite_to_exam_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "unite_to_exam_id_seq" OWNED BY "unite_to_exam".id;


--
-- TOC entry 190 (class 1259 OID 18184)
-- Name: unites; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE unites (
    id bigint NOT NULL,
    "course_id" integer,
    name character varying(255),
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone
);


ALTER TABLE unites OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 18182)
-- Name: unites_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE unites_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE unites_id_seq OWNER TO postgres;

--
-- TOC entry 2255 (class 0 OID 0)
-- Dependencies: 189
-- Name: unites_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE unites_id_seq OWNED BY unites.id;


--
-- TOC entry 184 (class 1259 OID 18125)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id bigint NOT NULL,
    name character varying(255),
    surname character varying(255),
    password character varying(255),
    username character varying(255),
    type integer,
    "created_at" timestamp without time zone,
    "updated_at" timestamp without time zone,
    email character varying(100)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 18123)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2256 (class 0 OID 0)
-- Dependencies: 183
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2080 (class 2604 OID 18248)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment ALTER COLUMN id SET DEFAULT nextval('comment_id_seq'::regclass);


--
-- TOC entry 2072 (class 2604 OID 18120)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "contact_type" ALTER COLUMN id SET DEFAULT nextval('"contact_type_id_seq"'::regclass);


--
-- TOC entry 2075 (class 2604 OID 18179)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courses ALTER COLUMN id SET DEFAULT nextval('courses_id_seq'::regclass);


--
-- TOC entry 2077 (class 2604 OID 18201)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "exam_type" ALTER COLUMN id SET DEFAULT nextval('"exam_type_id_seq"'::regclass);


--
-- TOC entry 2079 (class 2604 OID 18227)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post ALTER COLUMN id SET DEFAULT nextval('post_id_seq'::regclass);


--
-- TOC entry 2074 (class 2604 OID 18139)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile ALTER COLUMN id SET DEFAULT nextval('profile_id_seq'::regclass);


--
-- TOC entry 2078 (class 2604 OID 18209)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "unite_to_exam" ALTER COLUMN id SET DEFAULT nextval('"unite_to_exam_id_seq"'::regclass);


--
-- TOC entry 2076 (class 2604 OID 18187)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unites ALTER COLUMN id SET DEFAULT nextval('unites_id_seq'::regclass);


--
-- TOC entry 2073 (class 2604 OID 18128)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2239 (class 0 OID 18245)
-- Dependencies: 198
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO comment (id, "post_id", "user_id", "comment_description", "comment_image_path", "is_answer", "created_at", "updated_at") VALUES (4, 2, 1, 'asdasd', 'asdasdasd', false, NULL, NULL);


--
-- TOC entry 2257 (class 0 OID 0)
-- Dependencies: 197
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('comment_id_seq', 4, true);


--
-- TOC entry 2223 (class 0 OID 18117)
-- Dependencies: 182
-- Data for Name: contact_type; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 181
-- Name: contact_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"contact_type_id_seq"', 1, false);


--
-- TOC entry 2229 (class 0 OID 18176)
-- Dependencies: 188
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (3, 'Türkçe', '2017-01-19 16:18:38.358', '2017-01-20 01:05:57.157');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (6, NULL, '2017-01-20 15:57:21.893', '2017-01-20 15:57:21.893');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (7, 'ali', '2017-01-20 15:58:41.754', '2017-01-20 15:58:41.754');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (8, 'veli', '2017-01-20 19:02:13.321', '2017-01-20 19:02:13.321');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (9, 'matematik', '2017-01-20 19:03:21.852', '2017-01-20 19:03:21.852');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (10, 'a', '2017-01-21 14:30:44.231', '2017-01-21 14:30:44.231');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (11, 'b', '2017-01-21 14:30:46.923', '2017-01-21 14:30:46.923');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (12, 'contact_type_id', '2017-01-21 14:30:48.989', '2017-01-21 14:30:48.989');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (13, 'z', '2017-01-21 16:25:44.571', '2017-01-21 16:25:44.571');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (14, 'veli', '2017-01-24 19:41:23.109', '2017-01-24 19:41:23.109');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (4, 'z', '2017-01-20 15:56:45.136', '2017-01-27 23:39:40.407');
INSERT INTO courses (id, name, "created_at", "updated_at") VALUES (15, 'aaa', '2017-01-27 23:45:02.366', '2017-01-27 23:45:02.366');


--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 187
-- Name: courses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('courses_id_seq', 15, true);


--
-- TOC entry 2233 (class 0 OID 18198)
-- Dependencies: 192
-- Data for Name: exam_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "exam_type" (id, "exam_name", "created_at", "updated_at") VALUES (1, 'KPSS', '2017-01-22 15:54:20.038', '2017-01-22 15:54:20.038');


--
-- TOC entry 2260 (class 0 OID 0)
-- Dependencies: 191
-- Name: exam_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"exam_type_id_seq"', 5, true);


--
-- TOC entry 2237 (class 0 OID 18224)
-- Dependencies: 196
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO post (id, "user_id", "unite_id", "post_description", "post_imagePath", "created_at", "updated_at") VALUES (2, 1, 1, 'sadasd', 'asdasd', NULL, NULL);
INSERT INTO post (id, "user_id", "unite_id", "post_description", "post_imagePath", "created_at", "updated_at") VALUES (3, 5, 1, 'description', 'image', '2017-01-30 18:47:20.14', '2017-01-30 18:47:20.14');


--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 195
-- Name: post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('post_id_seq', 3, true);


--
-- TOC entry 2227 (class 0 OID 18136)
-- Dependencies: 186
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 185
-- Name: profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('profile_id_seq', 1, false);


--
-- TOC entry 2235 (class 0 OID 18206)
-- Dependencies: 194
-- Data for Name: unite_to_exam; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (1, 1, 1, NULL, NULL);
INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (3, 1, 1, NULL, NULL);
INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (6, 1, 1, NULL, NULL);
INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (7, 1, 1, NULL, NULL);
INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (13, 1, 1, NULL, NULL);
INSERT INTO "unite_to_exam" (id, "exam_type_id", "unite_id", "created_at", "updated_at") VALUES (14, 1, 1, NULL, NULL);


--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 193
-- Name: unite_to_exam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"unite_to_exam_id_seq"', 14, true);


--
-- TOC entry 2231 (class 0 OID 18184)
-- Dependencies: 190
-- Data for Name: unites; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (1, 3, 'wwww', '2017-01-19 16:43:58.453', '2017-01-20 14:33:35.979');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (4, 3, '1111aaa', '2017-01-19 17:25:04.232', '2017-01-20 00:50:29.52');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (6, 3, 'ali', '2017-01-22 21:57:18.305', '2017-01-22 21:57:18.306');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (7, 3, 'asda', '2017-01-22 22:04:07.921', '2017-01-22 22:04:07.921');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (10, 3, 'sad', '2017-01-22 22:28:26.712', '2017-01-22 22:28:26.712');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (11, 3, 'aaaaa', '2017-01-24 00:38:05.846', '2017-01-24 00:38:05.846');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (12, 3, 'a', '2017-01-24 19:40:57.613', '2017-01-24 19:40:57.613');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (16, 3, 'asdasd', '2017-01-28 00:24:12.729', '2017-01-28 00:24:12.729');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (13, 3, 'b', '2017-01-24 19:41:01.229', '2017-01-24 19:41:01.229');
INSERT INTO unites (id, "course_id", name, "created_at", "updated_at") VALUES (17, 3, 'asdasd', '2017-01-28 00:24:15.475', '2017-01-28 00:24:15.475');


--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 189
-- Name: unites_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('unites_id_seq', 17, true);


--
-- TOC entry 2225 (class 0 OID 18125)
-- Dependencies: 184
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (1, NULL, NULL, NULL, NULL, 0, '2017-01-25 23:07:12.743', '2017-01-25 23:07:12.743', NULL);
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (2, NULL, NULL, NULL, NULL, 0, '2017-01-25 23:07:20.513', '2017-01-25 23:07:20.513', NULL);
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (3, NULL, NULL, NULL, NULL, 0, '2017-01-25 23:07:39.392', '2017-01-25 23:07:39.392', NULL);
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (4, NULL, NULL, NULL, NULL, 1, '2017-01-25 23:15:09.667', '2017-01-25 23:15:09.667', NULL);
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (7, 'uhud', 'poyraz', 'password', NULL, 1, '2017-01-25 23:22:19.382', '2017-01-25 23:22:19.382', 'email');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (6, 'uhud', 'poyraz', 'password', 'uhudpoyraz', 1, '2017-01-25 23:22:14.794', '2017-01-25 23:22:14.794', 'email');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (5, 'uhud', 'poyraz', 'u', 'u', 1, '2017-01-25 23:20:49.417', '2017-01-25 23:20:49.417', 'u');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (8, 'uhud', 'poyraz', '123456', NULL, 0, '2017-02-06 17:30:07.481', '2017-02-06 17:30:07.481', 'uhud.poyraz@gmail.com');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (9, 'asd', 'asd', 'asd', NULL, 0, '2017-02-06 17:36:50.952', '2017-02-06 17:36:50.952', 'asd@asd.com');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (10, 'ada', 'asdas', '111', NULL, 0, '2017-02-06 17:41:13.153', '2017-02-06 17:41:13.153', 'asda');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (11, 'asd', 'asd', 'asd', NULL, 0, '2017-02-06 17:41:49.435', '2017-02-06 17:41:49.435', 'asd');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (12, 'das', 'asd', 'asd', NULL, 0, '2017-02-06 17:44:31.593', '2017-02-06 17:44:31.593', 'sad');
INSERT INTO users (id, name, surname, password, username, type, "created_at", "updated_at", email) VALUES (13, 'asd', 'asd', 'asd', NULL, 0, '2017-02-06 18:02:05.282', '2017-02-06 18:02:05.282', 'asd');


--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 183
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 13, true);


--
-- TOC entry 2098 (class 2606 OID 18253)
-- Name: comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- TOC entry 2082 (class 2606 OID 18122)
-- Name: contact_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "contact_type"
    ADD CONSTRAINT "contact_type_pkey" PRIMARY KEY (id);


--
-- TOC entry 2088 (class 2606 OID 18181)
-- Name: courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);


--
-- TOC entry 2092 (class 2606 OID 18203)
-- Name: exam_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "exam_type"
    ADD CONSTRAINT "exam_type_pkey" PRIMARY KEY (id);


--
-- TOC entry 2096 (class 2606 OID 18232)
-- Name: post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


--
-- TOC entry 2086 (class 2606 OID 18141)
-- Name: profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2094 (class 2606 OID 18211)
-- Name: unite_to_exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "unite_to_exam"
    ADD CONSTRAINT "unite_to_exam_pkey" PRIMARY KEY (id);


--
-- TOC entry 2090 (class 2606 OID 18189)
-- Name: unites_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unites
    ADD CONSTRAINT unites_pkey PRIMARY KEY (id);


--
-- TOC entry 2084 (class 2606 OID 18133)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2106 (class 2606 OID 18254)
-- Name: comment_post_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT "comment_post_id_fkey" FOREIGN KEY ("post_id") REFERENCES post(id);


--
-- TOC entry 2107 (class 2606 OID 18259)
-- Name: comment_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT "comment_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES users(id);


--
-- TOC entry 2105 (class 2606 OID 18238)
-- Name: post_unite_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT "post_unite_id_fkey" FOREIGN KEY ("unite_id") REFERENCES unites(id);


--
-- TOC entry 2104 (class 2606 OID 18233)
-- Name: post_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT "post_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES users(id);


--
-- TOC entry 2100 (class 2606 OID 18147)
-- Name: profile_contact_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT "profile_contact_type_id_fkey" FOREIGN KEY ("contact_type_id") REFERENCES "contact_type"(id);


--
-- TOC entry 2099 (class 2606 OID 18142)
-- Name: profile_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT "profile_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES users(id);


--
-- TOC entry 2102 (class 2606 OID 18212)
-- Name: unite_to_exam_exam_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "unite_to_exam"
    ADD CONSTRAINT "unite_to_exam_exam_type_id_fkey" FOREIGN KEY ("exam_type_id") REFERENCES "exam_type"(id);


--
-- TOC entry 2103 (class 2606 OID 18217)
-- Name: unite_to_exam_unite_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "unite_to_exam"
    ADD CONSTRAINT "unite_to_exam_unite_id_fkey" FOREIGN KEY ("unite_id") REFERENCES unites(id);


--
-- TOC entry 2101 (class 2606 OID 18190)
-- Name: unites_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unites
    ADD CONSTRAINT "unites_course_id_fkey" FOREIGN KEY ("course_id") REFERENCES courses(id);


--
-- TOC entry 2246 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-02-12 16:01:33 +03

--
-- PostgreSQL database dump complete
--
