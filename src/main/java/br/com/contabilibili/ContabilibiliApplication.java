package br.com.contabilibili;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.contabilibili.ui.JavaFxApplication;
import javafx.application.Application;

@SpringBootApplication
public class ContabilibiliApplication {
	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}
}