package hello.jdbc.connection;

import java.sql.Connection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DBConnectionUtilTest {

	@Test
	void connetion() {
		Connection connection = DBConnectionUtil.getConnection();
		Assertions.assertThat(connection).isNotNull();
	}
}