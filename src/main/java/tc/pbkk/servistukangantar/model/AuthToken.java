package tc.pbkk.servistukangantar.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.google.gson.annotations.SerializedName;

@ConfigurationProperties("authtoken")
public class AuthToken {
	@SerializedName("access_token")
	private String accessToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	@SerializedName("token_type")
	private String tokenType;
	@SerializedName("refresh_token")
	private String refreshToken;
	@SerializedName("expires_in")
	private String expiresIn;
	@SerializedName("scope")
	private String scope;
	@SerializedName("sub")
	private String sub;
	@SerializedName("user_type")
	private String userType;
	@SerializedName("jti")
	private String jti;
}
