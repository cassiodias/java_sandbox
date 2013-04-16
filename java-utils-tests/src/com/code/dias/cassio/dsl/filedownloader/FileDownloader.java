package com.code.dias.cassio.dsl.filedownloader;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * FileDownloader Util using DSL example.
 * 
 * <i><b>Example of usage:</b> String url = "YOUR_URL";<br>
 * String destDir = "c://[YOUR_DIRECTORY]//";<br>
 * <br>
 * e.g:<br>
 * String result = new FileDownloader().<br>
 * 	fromAddress(url).toDir(destDir)<br>
 * 		.getNow());</i>
 * 
 * @author C‡ssio Dias
 */
public class FileDownloader {

    private final static int size = 1024;
    private String destinationDir;
    private String fileAddress;
    private String fileName;

    /**
     * To test !
     */
    public static void main(String[] args) {
	String url = "http://www.site.com/file.txt";
	String destDir = "/user/cassio/downloadtest/";

	System.out.println(
		new FileDownloader().fromAddress(url).toDir(destDir)
			.getNow());
    }
    
    /**
     * Executes the download file.
     * 
     * @exception DownloaderRuntimeException
     *                if there is any IO or MalformedURL Exception.
     * @return String object with return of operation.
     */
    public String getNow() {

	OutputStream os = null;
	URLConnection URLConn = null;
	InputStream is = null;
	int ByteRead, ByteWritten = 0;

	try {
	    URL fileUrl;
	    byte[] buf;

	    fileUrl = new URL(fileAddress);
	    os = new BufferedOutputStream(new FileOutputStream(
		    this.destinationDir + "\\" + this.fileName));

	    URLConn = fileUrl.openConnection();
	    is = URLConn.getInputStream();
	    buf = new byte[size];
	    while ((ByteRead = is.read(buf)) != -1) {
		os.write(buf, 0, ByteRead);
		ByteWritten += ByteRead;
	    }

	} catch (MalformedURLException e) {
	    throw new DownloaderRuntimeException(e.getMessage());

	} catch (IOException e) {
	    throw new DownloaderRuntimeException(e.getMessage());

	} finally {
	    try {
		is.close();
		os.close();
	    } catch (IOException e) {
		throw new DownloaderRuntimeException(e.getMessage());
	    }
	}
	return new StringBuilder("Downloaded Successfully. ")
		.append("File name: ").append(this.fileName).append(" bytes :")
		.append(ByteWritten).append("Mb").toString();
    }

    public FileDownloader fromAddress(String fileAddress) {
	int lastIndexOfSlash = fileAddress.lastIndexOf('/');
	int lastIndexOfPeriod = fileAddress.lastIndexOf('.');

	// Is path or file name given correctly?
	if (lastIndexOfPeriod >= 1 && lastIndexOfSlash >= 0
		&& lastIndexOfSlash < fileAddress.length() - 1) {
	    this.fileAddress = fileAddress;

	    // Get the name of file to be downloaded.
	    this.fileName = fileAddress.substring(lastIndexOfSlash + 1);

	} else {
	    throw new DownloaderRuntimeException(
		    "Specify correct path or file name.");
	}
	return this;
    }

    public FileDownloader toDir(String destinationDir) {
	this.destinationDir = destinationDir;
	return this;
    }

    //Inner just for convenience... :)
    public class DownloaderRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DownloaderRuntimeException(String message) {
	    super(message);
	}
    }

}
