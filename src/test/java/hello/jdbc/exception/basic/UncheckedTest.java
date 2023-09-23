package hello.jdbc.exception.basic;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UncheckedTest {

	@Test
	void unchecked_catch() {
		Service service = new Service();
		service.callCatch();
	}

	@Test
	void uncheked_throw() {
		Service service = new Service();

		assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyuncheckedException.class);
	}

	/**
	 * RuntimeException 을 상속받은 예외는 언체크 예외가 된다.
	 */
	static class MyuncheckedException extends RuntimeException {
		public MyuncheckedException(String message) {
			super(message);
		}
	}

	/**
	 * Unchecked 예외는
	 * 예외를 잡거나, 던지지 않아도 됩니다.
	 * 예외를 잡지 않으면 자동으로 밖으로 던진다.
	 */
	static class Service {
		Repositroy repositroy = new Repositroy();

		/**
		 * 필요한 경우 예외를 잡아서 처리하면 된다.
		 */
		public void callCatch() {
			try {
				repositroy.call();
			} catch (MyuncheckedException e) {
				log.info("예외 처리, message = {}", e.getMessage(), e);
			}

		}

		/**
		 * 예외를 잡지 않아도 된다. 자연스럽게 상위로 넘어간다.
		 * 체크 예외와 다르게 throws 예외 선언을 하지 않아도 된다.
		 */
		public void callThrow() {
			repositroy.call();
		}

	}

	static class Repositroy {
		public void call() {
			throw new MyuncheckedException("ex");
		}
	}

}
