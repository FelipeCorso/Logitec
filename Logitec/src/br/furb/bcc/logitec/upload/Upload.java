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

	    Iterator it = fileItemsList.iterator();

	    do {

		cont++;

		FileItem fileItemTemp = (FileItem) it.next();

		if (fileItemTemp.isFormField()) {
		    if (fileItemTemp.getFieldName().equals("file")) {
			optionalFileName = fileItemTemp.getString();
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

			    // String dirName = "/P2012-09/web/WEB-INF/imgupload/"; // caminho para o projeto
			    String dirName = request.getServletContext().getRealPath("/");
			    File saveTo = new File(dirName + fileName);
			    System.out.println("caminho: " + saveTo.toString());
			    try {
				fileItem.write(saveTo);
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
