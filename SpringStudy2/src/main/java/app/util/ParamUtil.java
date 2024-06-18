package app.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import app.dto.ParamDTO;

@Component
public class ParamUtil {
	
	public ParamDTO getParam(HttpServletRequest req) {
		ParamDTO param = new ParamDTO();
		param.setState(false);
		Map<String, Object> map = new HashMap<>();
		Enumeration enu = req.getParameterNames();
		while(enu.hasMoreElements()) {
			String tmp = enu.nextElement().toString();
			String content = req.getParameter(tmp);
			map.put(tmp, content);
			param.setState(true);	
		}
		param.setMap(map);
		return param;
	}
}
