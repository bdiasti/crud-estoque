package br.com.estoque.core;

public class jogoTests {
	
	//

//	public Jogo geraJogo(String titulo) {
//		Jogo jogo = new Jogo();
//		jogo.setId((int) Math.random()  * 101);
//		jogo.setTitulo(titulo);
//		return jogo;
//	}
//	
//	public Pontuacao geraPontuacao(Jogo jogo, String nome, int pontuacao) {
//		Pontuacao pontuacaoBuraco = new Pontuacao();
//		pontuacaoBuraco.setId((int) Math.random());
//		pontuacaoBuraco.setNome(nome);
//		pontuacaoBuraco.setPontuacao(pontuacao);
//		pontuacaoBuraco.setJogo(jogo);
//		
//		return pontuacaoBuraco;
//	}
//	
//	public Jogador geraJogador(String nome) {	
//		Jogador jogador = new Jogador();
//		int random =  (int) (Math.random() * 999);
//		jogador.setId(random);
//		jogador.setNome(nome);
//		return jogador;
//	}
//	
//	public Partida geraPartida(String titulo, Jogo jogo ) {
//		Partida partida = new Partida();
//		partida.setTitulo(titulo);
//		partida.setJogo(jogo);
//		return partida;
//	}
//	
//	public PartidaPontuacao geraPartidaPontuacao(Partida partida, Jogador jogador, Pontuacao pontuacao) {
//		PartidaPontuacao partidaPontuacao = new PartidaPontuacao();
//		partidaPontuacao.setPartida(partida);
//		partidaPontuacao.setJogador(jogador);
//		partidaPontuacao.setPontuacao(pontuacao);
//		return partidaPontuacao;
//	}
//	
//	//Atualiza a pontuacao do jogador apos termino da partida.
//	@Test
//	public void atualizaPontuacaoJogadorTerminoPartidaTest() {
//		
//		//Cria Pega Jogo Buraco
//		Jogo jogo = geraJogo("Buraco");
//		//Associa aos pontos do Buraco
//		Pontuacao pontuacaoBuracoVitoria = geraPontuacao(jogo, "VICTORY", 100);
//		Pontuacao pontuacaoBuracoDerrota = geraPontuacao(jogo, "DEFEAT", -20);
//		Pontuacao pontuacaoBuracoEmpate = geraPontuacao(jogo, "DRAW", 50);
//		
//		//Cria uma partida de jogo de buraco
//		Partida partida = geraPartida("Vem jogar buraco!!", jogo);
//		
//		//Cria jogadores para partida
//		Jogador jogadorBernardo = geraJogador("Bernardo");
//		Jogador jogadorJoao = geraJogador("Joao");
//		
//		//SELECT id FROM partida partidap where partidap.id = :id_partida_interface and  partidap.id_jogador = :id_jogador_interface nome = :nome_interface 
//		//UPDATE partida_pontuacao set where 
//		//Ao finalizar a partida atribui a pontuacao de vitoria do Jogador Bernardo na partida de buraco
//		PartidaPontuacao partidaPontuacaoBernardo = geraPartidaPontuacao(partida, jogadorBernardo, pontuacaoBuracoVitoria);
//	
//		
//		assertEquals(100, partidaPontuacaoBernardo.getPontuacaoNumero());
//	}
//	
//	
//	//Mostra top ranqueado de determinada partida
//	@Test
//	public void criandoPontuacaoDeUmJogo() {
//		
//		//Cria Pega Jogo Buraco
//		Jogo jogo = geraJogo("Buraco");
//		//Associa aos pontos do Buraco
//		Pontuacao pontuacaoBuracoVitoria = geraPontuacao(jogo, "VICTORY", 100);
//		Pontuacao pontuacaoBuracoDerrota = geraPontuacao(jogo, "DEFEAT", -20);
//		Pontuacao pontuacaoBuracoEmpate = geraPontuacao(jogo, "DRAW", 50);
//		
//		//Cria uma partida de jogo de buraco
//		Partida partida = geraPartida("Vem jogar buraco!!", jogo);
//		
//		//Cria jogadores para partida
//		Jogador jogadorBernardo = geraJogador("Bernardo");
//		Jogador jogadorJoao = geraJogador("Joao");
//		Jogador jogadorRomario = geraJogador("Romario");
//		
//		//Ao finalizar a partida atribui a pontuacao de vitoria do Jogador Bernardo na partida de buraco
//		PartidaPontuacao partidaPontuacaoBernardo = geraPartidaPontuacao(partida, jogadorBernardo, pontuacaoBuracoVitoria);
//	
//		//Ao finalizar a partida atribui a pontuacao de derrota do Jogador Joao na partida de buraco
//		PartidaPontuacao partidaPontuacaoJoao = geraPartidaPontuacao(partida, jogadorJoao, pontuacaoBuracoDerrota);	
//		
//		//Ao finalizar a partida atribui a pontuacao de derrota do Jogador Joao na partida de buraco
//		PartidaPontuacao partidaPontuacaoRomario = geraPartidaPontuacao(partida, jogadorRomario, pontuacaoBuracoEmpate);	
//		
//		//Simula as partidaPontuacao que vem da base de dados.
//		ArrayList<PartidaPontuacao> partidaPontuacaoBuraco = new ArrayList<PartidaPontuacao>();
//		partidaPontuacaoBuraco.add(partidaPontuacaoJoao);
//		partidaPontuacaoBuraco.add(partidaPontuacaoBernardo);
//		partidaPontuacaoBuraco.add(partidaPontuacaoRomario);
//		
//		List<PartidaPontuacao> sortedpartidaPontuacaoBuraco = partidaPontuacaoBuraco
//		        .stream()
//		        .sorted(Comparator.comparingInt(PartidaPontuacao::getPontuacaoNumero).reversed())
//		        .collect(Collectors.toList());
//		
//		assertEquals(jogadorBernardo.getNome(), sortedpartidaPontuacaoBuraco.stream().findFirst().get().getJogador().getNome());
//		
//		
//	}
//	
//	
//	//Disponbiliza a pontuacao do jogador no Ranking
//	@Test
//	public void posicaoDoJogadorNoRanking() {
//		
//		//Cria Pega Jogo Buraco
//		Jogo jogo = geraJogo("Buraco");
//		//Associa aos pontos do Buraco
//		Pontuacao pontuacaoBuracoVitoria = geraPontuacao(jogo, "VICTORY", 100);
//		Pontuacao pontuacaoBuracoDerrota = geraPontuacao(jogo, "DEFEAT", -20);
//		Pontuacao pontuacaoBuracoEmpate = geraPontuacao(jogo, "DRAW", 50);
//		
//		//Cria uma partida de jogo de buraco
//		Partida partida = geraPartida("Vem jogar buraco!!", jogo);
//		
//		//Cria jogadores para partida
//		Jogador jogadorBernardo = geraJogador("Bernardo");
//		Jogador jogadorJoao = geraJogador("Joao");
//		
//		//Ao finalizar a partida atribui a pontuacao de vitoria do Jogador Bernardo na partida de buraco
//		PartidaPontuacao partidaPontuacaoBernardo = geraPartidaPontuacao(partida, jogadorBernardo, pontuacaoBuracoVitoria);
//	
//		//Ao finalizar a partida atribui a pontuacao de derrota do Jogador Joao na partida de buraco
//		PartidaPontuacao partidaPontuacaoJoao = geraPartidaPontuacao(partida, jogadorJoao, pontuacaoBuracoDerrota);	
//		
//		//Simula as partidaPontuacao que vem da base de dados.
//		ArrayList<PartidaPontuacao> partidaPontuacaoBuraco = new ArrayList<PartidaPontuacao>();
//		partidaPontuacaoBuraco.add(partidaPontuacaoJoao);
//		partidaPontuacaoBuraco.add(partidaPontuacaoBernardo);
//		
//		int pontuacao = 0;
//		for (PartidaPontuacao partidaPontuacao : partidaPontuacaoBuraco) {
//				if(partidaPontuacao.getJogador().getId() == jogadorBernardo.getId()) {
//					pontuacao = partidaPontuacao.getPontuacaoNumero();
//					break;
//				}
//		}
//		
//		
//		assertEquals(100,pontuacao);
//		
//		
//	}

}
