package br.furb.bcc.logitec.upload;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import br.furb.bcc.logitec.entidades.controle.dao.ClienteDAO;
import br.furb.bcc.logitec.entidades.modelo.pessoa.cliente.Cliente;

public class Upload {

    public Upload() {
    }

    public boolean anexos(HttpServletRequest request, HttpServletResponse response) throws Exception {

	if (ServletFileUpload.isMultipartContent(request)) {

	    int cont = 0;

	    ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

	    List fileItemsList = null;

	    try {
		fileItemsList = servletFileUpload.parseRequest(request);
	    } catch (FileUploadException e) {
		e.printStackTrace();
	    }

	    String optionalFileName = "";
	    FileItem fileItem = null;
	    Cliente cliente = new Cliente();
	    Iterator it = fileItemsList.iterator();

	    do {

		cont++;

		FileItem fileItemTemp = (FileItem) it.next();
		System.out.println("id inicio:" + fileItemTemp.getFieldName());
		if (fileItemTemp.isFormField()) {
		    if (fileItemTemp.getFieldName().equals("file")) {
			optionalFileName = fileItemTemp.getString();
		    }
		    if (fileItemTemp.getFieldName().equals("nome")) {
			System.out.println("id:" + fileItemTemp.getFieldName());
			System.out.println("campo:" + fileItemTemp.getString());

			cliente.setNome(fileItemTemp.getString());
		    }
		} else {
		    fileItem = fileItemTemp;
		}

		if (cont != (fileItemsList.size())) {
		    if (fileItem != null) {

			String fileName = fileItem.getName();

			if (fileItem.getSize() > 0) {

			    if (optionalFileName.trim().equals("")) {
				fileName = FilenameUtils.getName(fileName);
			    } else {
				fileName = optionalFileName;
			    }

			    // String dirName = "C:/imgupload/"; // caminho
			    String dirName = request.getServletContext().getRealPath("/");
			    File saveTo = new File(dirName + fileName);
			    System.out.println("caminho: " + saveTo.toString());
			    try {
				fileItem.write(saveTo);
				ClienteDAO clienteDAO = ClienteDAO.getInstance();
				clienteDAO.incluir(cliente, saveTo.toString());
			    } catch (Exception e) {
			    }

			}
		    }
		}
	    } while (it.hasNext());
	    return true;
	} else {
	    return false;
	}
    }
}
