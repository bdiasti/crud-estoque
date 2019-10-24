package br.com.estoque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import br.com.estoque.core.Produto;


public class ProdutoMapper implements ResultSetMapper<Produto>{

	public Produto map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
		
		Produto produto = new Produto();
		produto.setId(Long.parseLong((resultSet.getString("id"))));
		produto.setCategoria(resultSet.getString("categoria"));
		produto.setCodigoBarra(resultSet.getInt("codigoBarra"));
		produto.setDescricao(resultSet.getString("descricao"));
		produto.setQuantidade(resultSet.getLong("quantidade"));
		produto.setNome(resultSet.getString("nome"));
		return produto;
	}

}
