package br.furb.bcc.logitec.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	try {
	    if (new Upload().anexos(request, response)) {
		out.print("Ficheiro enviado!");
	    } else {
		out.print("Ficheiro não enviado!");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	try {
	    if (new Upload().anexos(request, response)) {
		out.println("<html>");
		out.println("<body>");
		out.println("Cliente cadastrado com sucesso</br>");
		out.println("<a href='Logitec/index.jsp#noticia1'>Voltar para home</a href>");
		out.println("</body>");
		out.println("</html>");

		out.print("Ficheiro enviado!");
	    } else {
		out.print("Ficheiro não enviado!");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// escreve o texto br.furb.bcc.logitec.upload.ServletUpload
	out.println("<html>");
	out.println("<body>");
	out.println("Primeira servlet");
	out.println("</body>");
	out.println("</html>");
    }
}
