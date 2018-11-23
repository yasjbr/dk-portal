/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.builder.ToStringBuilder
 *  org.apache.commons.lang.builder.ToStringStyle
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  ps.edu.diyar.common.utils.pagination.Pagination
 *  ps.edu.diyar.common.utils.pagination.TableProperties
 */
package ps.edu.diyar.common.utils.pagination;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ps.edu.diyar.common.utils.pagination.Pagination;
import ps.edu.diyar.common.utils.pagination.TableProperties;

public class ListHelper {
    private static Log log = LogFactory.getLog((Class)ListHelper.class);
    private List fullList;
    private int fullListSize;
    private int pageSize;
    private int pageCount;
    private int currentPage;
    private TableProperties properties = null;

    public ListHelper(int fullListSize, int pageSize, TableProperties tableProperties) {
        if (log.isDebugEnabled()) {
            log.debug((Object)("New ListHelper: size = " + this.fullList + "page size " + pageSize));
        }
        if (fullListSize != 0 && pageSize > 1) {
            this.fullListSize = fullListSize;
            this.pageSize = pageSize;
        }
        this.properties = tableProperties;
        this.pageCount = this.getPageCount();
        this.currentPage = 1;
    }

    private int getPageCount() {
        int result = 0;
        if (this.pageSize > 0) {
            int dev = this.fullListSize / this.pageSize;
            int mod = this.fullListSize % this.pageSize;
            result = mod == 0 ? dev : dev + 1;
        }
        return result;
    }

    public void setCurrentPage(int pageNumber) {
        this.currentPage = pageNumber < 1 || pageNumber != 1 && pageNumber > this.pageCount ? 1 : pageNumber;
    }

    public String getNavigationBar(String urlFormatString) {
        log.debug((Object)"getNavigationBar");
        int maxPages = this.properties.getPagingGroupSize(8);
        int currentIndex = this.currentPage;
        int count = this.pageCount;
        int startPage = 1;
        int endPage = maxPages;
        Pagination pagination = new Pagination(urlFormatString);
        if (count == 0) {
            pagination.addPage(1, true);
        }
        if (currentIndex < maxPages) {
            startPage = 1;
            endPage = maxPages;
            if (count < endPage) {
                endPage = count;
            }
        } else {
            startPage = currentIndex;
            while (startPage + maxPages > count + 1) {
                --startPage;
            }
            endPage = startPage + (maxPages - 1);
        }
        if (currentIndex != 1) {
            pagination.setFirstPage(new Integer(1));
            pagination.setNextPage(new Integer(currentIndex + 1));
            pagination.setPrevPage(new Integer(currentIndex - 1));
        }
        for (int i = startPage; i <= endPage; ++i) {
            pagination.addPage(i, i == currentIndex);
        }
        if (currentIndex != count) {
            pagination.setNextPage(new Integer(currentIndex + 1));
            pagination.setLastPage(new Integer(count));
        }
        String bannerFormat = pagination.isOnePage() ? this.properties.getPagingBannerOnePage() : (pagination.isFirst() ? this.properties.getPagingBannerFirst() : (pagination.isLast() ? this.properties.getPagingBannerLast() : this.properties.getPagingBannerFull()));
        return pagination.getFormattedBanner(this.properties.getPagingPageLink(), this.properties.getPagingPageSelected(), this.properties.getPagingPageSeparator(), bannerFormat);
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.SIMPLE_STYLE).append("fullListSize", this.fullListSize).append("pageSize", this.pageSize).append("pageCount", this.pageCount).append("properties", (Object)this.properties).append("currentPage", this.currentPage).toString();
    }
}