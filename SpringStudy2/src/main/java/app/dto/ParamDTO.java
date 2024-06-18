package app.dto;

import java.util.Map;

public class ParamDTO {
	private boolean state;
	private Map<String, Object> map;
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "paramDTO [state=" + state + ", map=" + map + "]";
	}
	
}
