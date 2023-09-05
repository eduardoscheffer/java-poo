package genericsSetMap.exerciciosSet.exercicioResolvido;

import java.time.Instant;
import java.util.Objects;

public class UserLog {
    private String username;
    private Instant loginTime;

    public UserLog(String name, Instant loginTime) {
        this.username = name;
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Instant loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLog userLog = (UserLog) o;
        return Objects.equals(username, userLog.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
