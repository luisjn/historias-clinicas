PGDMP     1    2            	    w            historias_clinicas    12.0    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    historias_clinicas    DATABASE     �   CREATE DATABASE historias_clinicas WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
 "   DROP DATABASE historias_clinicas;
                postgres    false                        3079    16420 	   uuid-ossp 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
    DROP EXTENSION "uuid-ossp";
                   false                       0    0    EXTENSION "uuid-ossp"    COMMENT     W   COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';
                        false    2            �            1259    16442    medical_record    TABLE     �   CREATE TABLE public.medical_record (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    medical_history bytea,
    patient_dni character varying(10),
    date date,
    file_name character varying(50)
);
 "   DROP TABLE public.medical_record;
       public         heap    postgres    false    2            �            1259    16431    patient    TABLE     w   CREATE TABLE public.patient (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    dni character varying(10)
);
    DROP TABLE public.patient;
       public         heap    postgres    false    2                      0    16442    medical_record 
   TABLE DATA           [   COPY public.medical_record (id, medical_history, patient_dni, date, file_name) FROM stdin;
    public          postgres    false    204   �                 0    16431    patient 
   TABLE DATA           *   COPY public.patient (id, dni) FROM stdin;
    public          postgres    false    203   �       �
           2606    16450 "   medical_record medical_record_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT medical_record_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.medical_record DROP CONSTRAINT medical_record_pkey;
       public            postgres    false    204            �
           2606    16462    patient patient_dni_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_dni_key UNIQUE (dni);
 A   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_dni_key;
       public            postgres    false    203            �
           2606    16439    patient patient_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_pkey;
       public            postgres    false    203            �
           2606    16463    medical_record mr_p    FK CONSTRAINT     �   ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT mr_p FOREIGN KEY (patient_dni) REFERENCES public.patient(dni) NOT VALID;
 =   ALTER TABLE ONLY public.medical_record DROP CONSTRAINT mr_p;
       public          postgres    false    2704    203    204                  x������ � �            x������ � �     