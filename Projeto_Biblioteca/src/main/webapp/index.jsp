<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "java.util.List,projeto_biblioteca.model.Usuario"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca</title>
    <link rel="stylesheet" href="index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<%
		String result = (String)request.getAttribute("result"); 
		String resultMessage = (String)request.getAttribute("resultMessage");
		
		Usuario usuarioLogado = null;
		
		// verifica se o usuário logou
		if(resultMessage == "Usuario Logado com sucesso"){
			usuarioLogado = (Usuario)request.getAttribute("usuarioLogado");
			resultMessage = "Usuario Logado com sucesso, bem vindo "+usuarioLogado.getNome() + " :)"; 
		}
	%>

	<!-- Alerta de sucesso -->
	<c:if test="${result == 'true'}">
		<div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
	        <svg class="bi flex-shrink-0 me-2" aria-label="Success:" xmlns="http://www.w3.org/2000/svg" width="24"
	            height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
	            stroke-linejoin="round" class="lucide lucide-check-icon lucide-check">
	            <path d="M20 6 9 17l-5-5" />
	        </svg>
	
	        <div>
	            <%=resultMessage %>
	        </div>
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    	</div>
	</c:if>
	
	<!-- Alerta de erro -->
	<c:if test="${result == 'false'}">
		<div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
	        <svg class="bi flex-shrink-0 me-2" aria-label="Success:" xmlns="http://www.w3.org/2000/svg" width="24"
	            height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
	            stroke-linejoin="round" class="lucide lucide-check-icon lucide-check">
	            <path d="M20 6 9 17l-5-5" />
	        </svg>
	
	        <div>
	            <%=resultMessage %>
	        </div>
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    	</div>
	</c:if>

    <nav>
        <div class="container-nav-nav">
            <article class="nav-wrapper">
                <label class="nav-item" for="dashboard">
                    <input type="radio" name="path" id="dashboard" />
                    <svg class="nav-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                        fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                        stroke-linejoin="round" class="lucide lucide-layout-dashboard-icon lucide-layout-dashboard">
                        <rect width="7" height="9" x="3" y="3" rx="1" />
                        <rect width="7" height="5" x="14" y="3" rx="1" />
                        <rect width="7" height="9" x="14" y="12" rx="1" />
                        <rect width="7" height="5" x="3" y="16" rx="1" />
                    </svg>
                    <span class="tooltip">Página Inicial</span>
                </label>

                <label class="nav-item" for="profile">
                    <input type="radio" name="path" id="profile" />
                    <svg class="nav-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                        fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                        stroke-linejoin="round" class="lucide lucide-user-icon lucide-user">
                        <path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2" />
                        <circle cx="12" cy="7" r="4" />
                    </svg>
                    <span class="tooltip">
	                    <c:choose>
							<c:when test="${usuarioLogado == null}">
								Entrar
							</c:when>
							<c:when test="${usuarioLogado != null}">
								Meu perfil
							</c:when>
						</c:choose>
                    </span>
                </label>

				<c:if test="${usuarioLogado != null}">
					<label class="nav-item" for="emprestimos">
	                    <input type="radio" name="path" id="emprestimos" />
	                    <svg class="nav-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
	                        fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
	                        stroke-linejoin="round" class="lucide lucide-handshake-icon lucide-handshake">
	                        <path d="m11 17 2 2a1 1 0 1 0 3-3" />
	                        <path
	                            d="m14 14 2.5 2.5a1 1 0 1 0 3-3l-3.88-3.88a3 3 0 0 0-4.24 0l-.88.88a1 1 0 1 1-3-3l2.81-2.81a5.79 5.79 0 0 1 7.06-.87l.47.28a2 2 0 0 0 1.42.25L21 4" />
	                        <path d="m21 3 1 11h-2" />
	                        <path d="M3 3 2 14l6.5 6.5a1 1 0 1 0 3-3" />
	                        <path d="M3 4h8" />
	                    </svg>
	                    <span class="tooltip">Empréstimos</span>
	                </label>
	
	                <label class="nav-item" for="multas">
	                    <input type="radio" name="path" id="multas" />
	                    <svg class="nav-icon multas" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
	                        viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
	                        stroke-linejoin="round" class="lucide lucide-heart-crack-icon lucide-heart-crack">
	                        <path
	                            d="M12.409 5.824c-.702.792-1.15 1.496-1.415 2.166l2.153 2.156a.5.5 0 0 1 0 .707l-2.293 2.293a.5.5 0 0 0 0 .707L12 15" />
	                        <path
	                            d="M13.508 20.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.677.6.6 0 0 0 .818.001A5.5 5.5 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5z" />
	                    </svg>
	                    <span class="tooltip">Multas</span>
	                </label>
	
					<!-- só aparece para usuarios do tipo 2, admins -->
	                <c:if test="${usuarioLogado.getTipo_usuario() == 2}">
		                <label class="nav-item" for="admin">
		                    <input type="radio" name="path" id="admin" />
		                    <svg class="nav-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
		                        fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
		                        stroke-linejoin="round" class="lucide lucide-wrench-icon lucide-wrench">
		                        <path
		                            d="M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.106-3.105c.32-.322.863-.22.983.218a6 6 0 0 1-8.259 7.057l-7.91 7.91a1 1 0 0 1-2.999-3l7.91-7.91a6 6 0 0 1 7.057-8.259c.438.12.54.662.219.984z" />
		                    </svg>
		                    <span class="tooltip">Gestão</span>
		                </label>
	                </c:if>
				</c:if>
            </article>
        </div>
    </nav>

    <main id="main-content">
        <!-- Página Inicial -->
        <div id="dashboard-content" class="content-section">
            <div class="card-livro d-flex align-items-center">
                <img class="me-3" src="https://placehold.co/200x300" alt="capa do livro">
                <div>
                    <h3 class="titulo-livro"><strong>Harry Potter e as Relíquias da Morte</strong></h3>
                    <div>Autor: Nome do Autor</div>
                    <div>Ano: 2023</div>
                    <div>Gênero: Ficção</div>
                    <div>Quantidade: 2/5</div>
                    <button class="btn btn-outline-primary mt-3">Reservar</button>
                </div>
            </div>

            <div class="card-livro d-flex align-items-center">
                <img class="me-3" src="https://placehold.co/200x300" alt="capa do livro">
                <div>
                    <h3 class="titulo-livro"><strong>Harry Potter e as Relíquias da Morte</strong></h3>
                    <div>Autor: Nome do Autor</div>
                    <div>Ano: 2023</div>
                    <div>Gênero: Ficção</div>
                    <div>Quantidade: 2/5</div>
                    <button class="btn btn-outline-primary mt-3">Reservar</button>
                </div>
            </div>

            <div class="card-livro d-flex align-items-center">
                <img class="me-3" src="https://placehold.co/200x300" alt="capa do livro">
                <div>
                    <h3 class="titulo-livro"><strong>Harry Potter e as Relíquias da Morte</strong></h3>
                    <div>Autor: Nome do Autor</div>
                    <div>Ano: 2023</div>
                    <div>Gênero: Ficção</div>
                    <div>Quantidade: 2/5</div>
                    <button class="btn btn-outline-primary mt-3">Reservar</button>
                </div>
            </div>

        </div>

        <!-- Entrar/Cadastrar -->
        
        <div id="profile-content" class="content-section" style="display: none;">
        
        	<c:choose>
				<c:when test="${usuarioLogado == null}">
					<div class="d-flex gap-4 flex-wrap justify-content-center align-items-start">
		                <!-- Form para cadastrar -->
		                <form action="UsuarioCadastroServlet" method="post" class="form" id="formCadastro">
		                    <p class="title">Criar conta</p>
		                    
		                    <input name="tipo_usuario" id="tipo_usuario" type="hidden" value="1">
		
		                    <label>
		                        <input name="nome" id="nome" required type="text" class="input">
		                        <span>Nome completo</span>
		                    </label>
		
		                    <label>
		                        <input name="telefone" id="telefone" required type="number" class="input">
		                        <span>Telefone</span>
		                    </label>
		
		                    <label>
		                        <input name="email" id="email" required type="email" class="input">
		                        <span>Email</span>
		                    </label>
		
		                    <label>
		                        <input name="senha" id="senha" required type="password" class="input">
		                        <span>Senha</span>
		                    </label>
		                    <label>
		                        <input id="confirmarSenha" required type="password" class="input">
		                        <span id="spanConfirmarSenha">Confirmar Senha</span>
		                    </label>
		                    <button class="btn btn-outline-primary">Enviar</button>
		                </form>
		                
		                <!-- Form para login -->
		                <form action="UsuarioLoginServlet" method="post" class="form">
		                    <p class="title">Entrar</p>
		
		                    <label>
		                        <input required type="email" name="email" id="email" class="input">
		                        <span>Email</span>
		                    </label>
		
		                    <label>
		                        <input required type="password" name="senha" id="senha" class="input">
		                        <span>Senha</span>
		                    </label>
		                    <button class="btn btn-outline-primary">Entrar</button>
		                </form>
		            </div>
				</c:when>
				<c:when test="${usuarioLogado != null}">
					Meu perfil
				</c:when>
			</c:choose>
            

        </div>

        <!-- Empréstimos -->
        <div id="emprestimos-content" class="content-section" style="display: none;">
            <h2 class="title">Meus empréstimos</h2>

            <table>
                <tr>
                    <th>Status</th>
                    <th>Livro</th>
                    <th>Data solicitação</th>
                    <th>Data retirada</th>
                    <th>Data devolução prevista</th>
                    <th>Data devolução real</th>
                </tr>
                <tr>
                    <td><span class="badge rounded-pill bg-warning text-dark">Em andamento</span></td>
                    <td>Harry Potter e as Relíquias da Morte</td>
                    <td>01/10/2023</td>
                    <td>03/10/2023</td>
                    <td>03/11/2023</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><span class="badge rounded-pill bg-success">Concluído</span></td>
                    <td>O Senhor dos Anéis</td>
                    <td>15/09/2023</td>
                    <td>16/09/2023</td>
                    <td>16/10/2023</td>
                    <td>15/10/2023</td>
                </tr>
            </table>

        </div>

        <!-- Multas -->
        <div id="multas-content" class="content-section" style="display: none;">
            <h2 class="title">Multas</h2>

            <table>
                <tr>
                    <th>Status</th>
                    <th>ID do emprestimo</th>
                    <th>Livro</th>
                    <th>Data emissão</th>
                    <th>Data vencimento</th>
                    <th>Valor</th>
                    <th>Data pagamento</th>
                </tr>
                <tr>
                    <td><span class="badge rounded-pill bg-warning text-dark">Pendente</span></td>
                    <td>12345</td>
                    <td>Harry Potter e as Relíquias da Morte</td>
                    <td>05/11/2023</td>
                    <td>20/11/2023</td>
                    <td>R$ 10,00</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><span class="badge rounded-pill bg-success">Paga</span></td>
                    <td>67890</td>
                    <td>O Senhor dos Anéis</td>
                    <td>20/10/2023</td>
                    <td>05/11/2023</td>
                    <td>R$ 15,00</td>
                    <td>04/11/2023</td>
                </tr>
            </table>
        </div>

        <div id="admin-content" class="content-section" style="display: none;">
            <h2 class="title">Administração</h2>
            <p>Conteúdo administrativo aqui.</p>
        </div>
    </main>

    <script src="index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
        integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
        crossorigin="anonymous"></script>


