package rootPackage.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LogbackFilter extends Filter<ILoggingEvent>{
    @Override
    public FilterReply decide(ILoggingEvent e){
//        System.out.println(e.getLoggerName());
        if(e.getMessage().contains("process.if_info_logs")) { // 로그는 출력 안함
            return FilterReply.DENY;
        } else {
            return FilterReply.ACCEPT;
        }
    }
}
