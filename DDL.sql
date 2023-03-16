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

-- CRIANDO TABELA DE SERVIÇOS
create table if not exists servicos (
	"id" uuid primary key default uuid_generate_v4 (),
	"nome" varchar(100) not null,
	"codigo" varchar(4) not null,
	"tipo" char(1) not null,
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
