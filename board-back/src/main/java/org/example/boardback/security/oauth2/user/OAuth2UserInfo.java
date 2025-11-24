package org.example.boardback.security.oauth2.user;

import java.util.Map;

/**
 * 각 OAuth2 provider(구글/카카오/네이버)의 사용자 정보를
 *  공통 포맷으로 추상화하는 클래스
 * */
public abstract class OAuth2UserInfo {
    protected final Map<String,Object> attributes;

    protected OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getEmail();

    public abstract String getName();

    public abstract String getImageUrl();


}
