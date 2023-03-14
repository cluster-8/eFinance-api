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
	"cnpjFormatado" varchar(14),

	unique ("nome", "cnpj")
);

-- CRIANDO TABELA DE SERVIÇOS
create table if not exists servicos (
	"id" uuid primary key default uuid_generate_v4 (),
	"codigo" varchar(4) not null,
	"tipo" char(1) not null,

	unique ("codigo", "tipo")
);

-- CRIANDO TABELA DE TARIFAS
create table if not exists tarifas (
	"id" uuid primary key default uuid_generate_v4 (),
	"servicoId" uuid not null,
	"instituicaoId" uuid not null,
	"valorMaximo" float not null,
	"dataVigencia" date not null,
	"unidade" varchar(20),
	"periodicidade" varchar(20),
	"moeda" varchar(10),

	constraint fk_servico foreign key("servicoId") references servicos(id),
	constraint fk_instituicao foreign key("instituicaoId") references instituicoes(id),

	unique ("servicoId", "instituicaoId", "valorMaximo", "dataVigencia", "periodicidade", "unidade")
);
