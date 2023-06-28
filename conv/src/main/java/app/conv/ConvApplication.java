package app.conv;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;

import app.conv.input.Report;
import app.conv.input.ReportJson;

@SpringBootApplication
public class ConvApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ConvApplication.class, args);
		
		String jsonSourceString = "[{\"id\":1816511101,\"type\":1,\"zoneCode\":\"SB2D\",\"zoneDescription\":\"Zona Tarragona Sur\",\"name\":\"ROCA\",\"companyId\":\"0010981\",\"company\":\"Endesa Distr.Electrica\",\"address\":\"C/ DE LA RIERA S/N\",\"features\":{\"transformers\":[{\"id\":1408431401,\"power\":100.0,\"transformation\":\"220/132\"},{\"id\":1408591401,\"power\":40.0,\"transformation\":\"132/25\"},{\"id\":1408621401,\"power\":40.0,\"transformation\":\"132/25\"},{\"id\":1419881401,\"power\":60.0,\"transformation\":\"220/25\"},{\"id\":1408631401,\"power\":40.0,\"transformation\":\"132/25\"}]}},{\"id\":1816,\"type\":1,\"zoneCode\":\"SB2D\",\"zoneDescription\":\"Zona Tarragona Sur\",\"name\":\"ROCA\",\"companyId\":\"0010981\",\"company\":\"Endesa Distr.Electrica\",\"address\":\"C/ DE LA RIERA S/N\",\"features\":{\"transformers\":[{\"id\":1408431401,\"power\":100.0,\"transformation\":\"220/132\"},{\"id\":1408591401,\"power\":40.0,\"transformation\":\"132/25\"},{\"id\":1408621401,\"power\":40.0,\"transformation\":\"132/25\"},{\"id\":1419881401,\"power\":60.0,\"transformation\":\"220/25\"},{\"id\":1408631401,\"power\":40.0,\"transformation\":\"132/25\"}]}}]";
		

		try {
			ReportJson.parseJsonArray(jsonSourceString);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
