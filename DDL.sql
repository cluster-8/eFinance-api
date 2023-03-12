-- CRIANDO TABELA DE GRUPOS CONSOLIDADOS
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists gc_grupo (
  gc_id uuid DEFAULT uuid_generate_v4 (),
  gc_codigo varchar(4) not null,
  gc_nome varchar(150) not null,
  primary key (gc_id),
  unique(gc_codigo)
);

-- CRIANDO TABELA DE INSTITUIÇÕES FINANCEIRAS
create table if not exists if_instituicao (
	if_id uuid DEFAULT uuid_generate_v4 (),
	if_grupo_id uuid null,
	if_nome varchar(100) not null,
	if_cnpj varchar(14) not null,
	if_cnpj_formatado varchar(14),
	primary key (if_id),
	CONSTRAINT fk_grupo
      FOREIGN KEY(if_grupo_id) 
	  REFERENCES gc_grupo(gc_id)
);

-- CRIANDO TABELA DE SERVIÇOS
create table if not exists sp_servico (
	sp_id uuid default uuid_generate_v4 (),
	sp_codigo varchar(4) not null,
	sp_tipo char(1) not null,
	primary key (sp_id)
);

-- CRIANDO TABELA DE TARIFAS
create table if not exists ts_tarifa (
	ts_id uuid default uuid_generate_v4 (),
	ts_servico_id uuid not null,
	ts_instituicao_id uuid not null,
	ts_valor_maximo numeric(3,2) not null,
	ts_data_vigencia date not null,
	ts_unidade varchar(20),
	ts_periodicidade varchar(20),
	ts_moeda varchar(10),
	primary key (ts_id),
	CONSTRAINT fk_servico
      FOREIGN KEY(ts_servico_id)
	  REFERENCES sp_servico(sp_id),
	CONSTRAINT fk_instituicao
      FOREIGN KEY(ts_instituicao_id)
	  REFERENCES if_instituicao(if_id)
);
