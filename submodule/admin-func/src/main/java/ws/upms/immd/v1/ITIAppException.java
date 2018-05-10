
package ws.upms.immd.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-01-05T16:41:14.910+08:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "ITIAppException", targetNamespace = "http://immd.itifwk.util/v1")
public class ITIAppException extends Exception {
    
    private util.itifwk.immd.v1.ITIAppException itiAppException;

    public ITIAppException() {
        super();
    }
    
    public ITIAppException(String message) {
        super(message);
    }
    
    public ITIAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITIAppException(String message, util.itifwk.immd.v1.ITIAppException itiAppException) {
        super(message);
        this.itiAppException = itiAppException;
    }

    public ITIAppException(String message, util.itifwk.immd.v1.ITIAppException itiAppException, Throwable cause) {
        super(message, cause);
        this.itiAppException = itiAppException;
    }

    public util.itifwk.immd.v1.ITIAppException getFaultInfo() {
        return this.itiAppException;
    }
}
