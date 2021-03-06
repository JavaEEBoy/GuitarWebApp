package security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.ProtectedURLManager;

public class HiddenCodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HiddenCodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		
		if(ProtectedURLManager.needHiddenCodeProtection(uri)){
			HttpSession session = httpRequest.getSession();
			String hiddenCode = request.getParameter("hiddenCode");
			String sessionHiddenCode = "";
			
			synchronized(session){
				sessionHiddenCode = (String) session.getAttribute("hiddenCode");
				if(ProtectedURLManager.needDeleteHiddenCodeProtection(uri))
					session.removeAttribute("hiddenCode");
			}
			
			if(sessionHiddenCode!=null&&hiddenCode!=null&&hiddenCode.equals(sessionHiddenCode)){
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else{
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.setStatus(403);
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
