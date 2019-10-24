package br.com.estoque.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.estoque.core.Produto;
import br.com.estoque.dao.ProdutoDao;
import io.swagger.annotations.Api;

@Api(value = " Endpoints Produto")
@Path("api/produto")
public class ProdutoResource {

	private ProdutoDao produto;

	public ProdutoResource(ProdutoDao myDao) {
		this.produto = myDao;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Produto> getProduto() {
		return produto.getProdutoList();
	}
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public  Produto getProdutoById(@PathParam("id") String id) {
		return produto.getProdutoById(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void adicionaProduto(Produto newProduto) {

		produto.insertToProduto(newProduto.getNome(), newProduto.getCodigoBarra(), newProduto.getDescricao(),
				newProduto.getQuantidade(), newProduto.getCategoria());
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean atualizaProduto(@PathParam("id") String id, Produto updateProduto) {
		if (produto.existsProduto(id)) {
			produto.atualizaProduto(id, updateProduto.getNome());
			return true;
		} else {
			return false;
		}
	}

	@Path("{id}")
	@DELETE
	public void deleta(@PathParam("id") String id) {
		produto.deletaProduto(id);
	}

}
