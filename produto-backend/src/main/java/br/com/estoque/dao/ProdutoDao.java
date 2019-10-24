package br.com.estoque.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import br.com.estoque.core.Produto;

public interface ProdutoDao {
	
	@SqlQuery("select * from produto")
	@Mapper(ProdutoMapper.class)
	public List<Produto> getProdutoList();
	
	@SqlUpdate("insert into produto (nome,codigoBarra,descricao,quantidade,categoria) values (:nome, :codigoBarra,:descricao,:quantidade,:categoria)")
	void insertToProduto(@Bind("nome") String nome, @Bind("codigoBarra") int codigoBarra,@Bind("descricao") String descricao, @Bind("quantidade") long quantidade,@Bind("categoria") String string);
	
	@SqlQuery("select COUNT(*) from produto where id = :id")
	boolean existsProduto( @Bind("id") String id );
	
	@SqlUpdate("UPDATE produto SET nome = :nome WHERE id = :id")
	void atualizaProduto( @Bind("id") String id, @Bind("nome") String nome );
	
	@SqlUpdate("DELETE FROM produto WHERE id = :id")
	void deletaProduto( @Bind("id") String id );
	
	@SqlQuery("select * from produto where id = :id")
	@Mapper(ProdutoMapper.class)
	Produto getProdutoById( @Bind("id") String id );
	
	
	
}
