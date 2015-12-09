package ar.com.trimatec.copre.model.exceptions;

public class ProductBarCodeNotUniqueException extends Exception {

	public String getMessage(){
		return "newproduct_barcode_not_unique_exception_message";
	}
}
