package com.service.tokenservice.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.service.tokenservice.model.Parametro;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Service 
public class API {

	private static WebClient webClient = WebClient.builder().build();

	private static Mono<String> handleResponse(WebClient.ResponseSpec responseSpec) {
		return responseSpec.bodyToMono(String.class).onErrorResume(e -> {
			if (e instanceof WebClientResponseException) {
				WebClientResponseException exception = (WebClientResponseException) e;
				if (exception.getStatusCode().is4xxClientError() || exception.getStatusCode().is5xxServerError()) {
					return Mono.error(new RuntimeException(LocalDateTime.now() + ": ERROR: " + exception.getResponseBodyAsString()));
				}
			}
			return Mono.error(e);
		});
	}

	public static String Get(String url, List<Parametro> headers) {
		WebClient.RequestHeadersSpec<?> request = webClient.get().uri(url);

		if (headers != null) {
			for (Parametro header : headers) {
				request = request.header(header.getClave(), header.getValor());
			}
		}

		return handleResponse(request.retrieve())
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).maxBackoff(Duration.ofSeconds(10))).block();
	}

	public static String Post(String url, List<Parametro> headers, Object body) {
		WebClient.RequestHeadersSpec<?> request = webClient.post().uri(url).contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(body));

		if (headers != null) {
			for (Parametro header : headers) {
				request = request.header(header.getClave(), header.getValor());
			}
		}

		return handleResponse(request.retrieve())
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).maxBackoff(Duration.ofSeconds(10))).block();
	}

	public static String Put(String url, List<Parametro> headers, Object body) {
		WebClient.RequestHeadersSpec<?> request = webClient.put().uri(url).contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(body));

		if (headers != null) {
			for (Parametro header : headers) {
				request = request.header(header.getClave(), header.getValor());
			}
		}

		return handleResponse(request.retrieve())
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).maxBackoff(Duration.ofSeconds(10))).block();
	}
}

