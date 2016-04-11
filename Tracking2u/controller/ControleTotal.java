 package tracking2u.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import tracking2u.dao.cadastroDao;
import tracking2u.dao.gastoDao;
import tracking2u.dao.loginDao;
import tracking2u.dao.pedidoDao;
import tracking2u.modelo.Contato;
import tracking2u.modelo.Pedidos;
import tracking2u.modelo.financeiro;

@Controller
public class ControleTotal {
	@RequestMapping("index")
	public String index() {
		return "index";

	}

	@RequestMapping("cadastro")
	public String cadastro() {
		return "cliente/cadastro";

	}

	@RequestMapping("cadastroc")
	public String cadastroc() {
		return "admin/cadastroc";

	}

	@RequestMapping("listac")
	public String listac() {
		return "redirect:listaPedidos1";

	}

	@RequestMapping("insereCliente")
	public String insere(Contato contato) {
		cadastroDao dao = new cadastroDao();
		dao.insere(contato);
		return "cliente/pedido";
	}

	@RequestMapping("insereCliente1")
	public String insere1(Contato contato) {
		cadastroDao dao = new cadastroDao();
		dao.insere(contato);
		return "admin/inicio";
	}

	@RequestMapping("exibeContato")
	public String exibe2(Long id, Model model) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		Contato contato= manager.find(Contato.class, id);
		manager.close();
		// AlunoDAO dao = new AlunoDAO();
		// model.addAttribute("aluno", dao.buscaPorId(id));
		model.addAttribute("contato", contato);
		return "admin/exibeu";
		}

	@RequestMapping("alteraContato")
	public String altera2(Contato contato) {
		// AlunoDAO dao = new AlunoDAO();
		// dao.altera(aluno);
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();
		return "admin/inicio";
	}
	@RequestMapping("exibeGastos")
	public String exibe(Long id, Model model) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		financeiro financeiro = manager.find(financeiro.class, id);
		manager.close();
		// AlunoDAO dao = new AlunoDAO();
		// model.addAttribute("aluno", dao.buscaPorId(id));
		model.addAttribute("financeiro", financeiro);
		return "admin/exibe";
	}
	@RequestMapping("alteraGasto")
	public String altera(financeiro financas) {
		// AlunoDAO dao = new AlunoDAO();
		// dao.altera(aluno);
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(financas);
		manager.getTransaction().commit();
		manager.close();
		return "admin/inicio";
	}
	@RequestMapping("insereDados")
	public String insere3(financeiro financeiro) {
		//gastoDao dao = new gastoDao();
		//dao.insere(financeiro);
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(financeiro);
		manager.getTransaction().commit();
		manager.close();

		return "admin/inicio";
	}


	@RequestMapping("mandaPedido")
	public String envia(Pedidos pedido) {
		pedidoDao dao = new pedidoDao();
		dao.envia(pedido);
		return "cliente/obrigado";
	}

	@RequestMapping("Login")
	public String Login(Contato contato) {
		loginDao dao = new loginDao();
		dao.buscaPorUsuario(contato);
		Contato volta = dao.buscaPorUsuario(contato);
		if (volta.getSenha().equals(contato.getSenha())) {
			if (volta.getNivel().equalsIgnoreCase("2")) {
				return "redirect:listaPedidos";
			}
			if (volta.getNivel().equalsIgnoreCase("3")) {
				return "admin/inicio";
			}

			return "cliente/pedido";
		}
		return "redirect:index";

	}

/*	@RequestMapping("Gastos")
	public Integer Gastos(Pedidos pedido) {
		pedidoDao dao = new pedidoDao();
		dao.precisadefinir();
		int valor=dao.precisadefinir();
		valor= valor*24;

		return valor;
		}
*/

	@RequestMapping("listaPedidos")
	public String lista11(Model model) {
		// AlunoDAO dao = new AlunoDAO();
		// model.addAttribute("alunos", dao.getLista());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Pedidos> pedidos = manager.createQuery("select a from Pedidos as a")
				.getResultList();
		model.addAttribute("pedidos", pedidos);
		manager.close();
		return "responsavel/lista";
}

	@RequestMapping("listaPedidos1")
	public String lista1(Model model) {
		// AlunoDAO dao = new AlunoDAO();
		// model.addAttribute("alunos", dao.getLista());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Pedidos> pedidos = manager.createQuery("select a from Pedidos as a")
				.getResultList();
		model.addAttribute("pedidos", pedidos);
		manager.close();
		return "admin/listac";}

	@RequestMapping("listaContatos")
	public String lista20(Model model) {
		// AlunoDAO dao = new AlunoDAO();
		// model.addAttribute("alunos", dao.getLista());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Contato> contato = manager.createQuery("select a from Contato as a")
				.getResultList();
		model.addAttribute("contato", contato);
		manager.close();
		return "admin/listau";}

		@RequestMapping("listaGastos")
		public String lista(Model model) {
			// AlunoDAO dao = new AlunoDAO();
			// model.addAttribute("alunos", dao.getLista());
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
			EntityManager manager = factory.createEntityManager();
			@SuppressWarnings("unchecked")
			List<financeiro> financeiro = manager.createQuery("select a from financeiro as a")
					.getResultList();
			model.addAttribute("financeiro", financeiro);
			manager.close();
			return "admin/gasto";
}

	@RequestMapping("mudaStatus")
	public void mudaStatus(Long id,HttpServletResponse response){
	pedidoDao dao = new pedidoDao();
	dao.finaliza(id);
	response.setStatus(200);
	}


	@RequestMapping("removeContato")
	public String remove(Contato contato) {
		// AlunoDAO dao = new AlunoDAO();
		// dao.remove(aluno);

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Contato encontrado = manager.find(Contato.class, contato.getId());
		manager.remove(encontrado);
		manager.getTransaction().commit();
		manager.close();
		return "admin/inicio";









	}}



