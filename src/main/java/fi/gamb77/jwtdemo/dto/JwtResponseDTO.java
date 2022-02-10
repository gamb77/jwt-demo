package fi.gamb77.jwtdemo.dto;

public class JwtResponseDTO {
    private String jwtToken;

    public JwtResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
