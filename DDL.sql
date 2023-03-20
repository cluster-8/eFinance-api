-- drop table if EXISTS tarifas;
-- drop table if EXISTS servicos;
-- drop table if EXISTS instituicoes;
-- drop table if EXISTS grupo;

-- CRIANDO TABELA DE GRUPOS CONSOLIDADOS
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- CRIANDO TABELA DE INSTITUIÇÕES FINANCEIRAS
create table if not exists instituicoes (
	"id" uuid primary key DEFAULT uuid_generate_v4 (),
	"nome" varchar(100) not null,
	"cnpj" varchar(14) not null,
	"cnpj_formatado" varchar(14),
	"created_at" timestamp not null default current_timestamp,

	unique ("nome", "cnpj")
);

CREATE TYPE servicosTipo AS ENUM ('F', 'J');

-- CRIANDO TABELA DE SERVIÇOS
create table if not exists servicos (
	"id" uuid primary key default uuid_generate_v4 (),
	"nome" varchar(100) not null,
	"codigo" varchar(4) not null,
	"tipo" servicosTipo not null,
	"created_at" timestamp not null default current_timestamp,

	unique ("codigo", "tipo")
);

-- CRIANDO TABELA DE TARIFAS
create table if not exists tarifas (
	"id" uuid primary key default uuid_generate_v4 (),
	"servico_id" uuid not null,
	"instituicao_id" uuid not null,
	"valor_maximo" float not null,
	"data_vigencia" date not null,
	"unidade" varchar(20),
	"periodicidade" varchar(20),
	"moeda" varchar(10),
	"created_at" timestamp not null default current_timestamp,

	constraint fk_servico foreign key("servico_id") references servicos(id),
	constraint fk_instituicao foreign key("instituicao_id") references instituicoes(id),

	unique ("servico_id", "instituicao_id", "valor_maximo", "data_vigencia", "periodicidade", "unidade")
);


CREATE TYPE apiTipo AS ENUM ('pix_saque', 'taxas_cartoes', 'canais_atendimento', 'pilar3');

-- CRIANDO TABELA DE APIS
create table if not exists apis (
	"id" uuid primary key default uuid_generate_v4 (),
	"apiTipo" apiTipo not null,
	"versao" varchar(10) not null,
	"recurso" varchar(100) not null,
	"argumento" varchar(100),
	"situacao" varchar(20) not null,
	"url_dados" varchar(250),
	"created_at" timestamp not null default current_timestamp,
	"instituicao_id" uuid not null,

	constraint fk_instituicao foreign key("instituicao_id") references instituicoes(id)
);
