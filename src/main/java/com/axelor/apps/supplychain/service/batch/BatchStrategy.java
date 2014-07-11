/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2012-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.supplychain.service.batch;

import com.axelor.apps.base.db.Batch;
import com.axelor.apps.base.service.administration.AbstractBatch;
import com.axelor.apps.sale.db.SaleOrder;
import com.axelor.apps.sale.service.SaleOrderInvoiceService;

public abstract class BatchStrategy extends AbstractBatch {

	protected BatchInvoicing batchInvoicing;
	
	protected SaleOrderInvoiceService saleOrderInvoiceService;
	
	protected BatchStrategy(SaleOrderInvoiceService saleOrderInvoiceService)  {
		super();
		this.saleOrderInvoiceService = saleOrderInvoiceService;
	}
	
	
	protected void updateSaleOrder( SaleOrder saleOrder ){
		
		saleOrder.addBatchSetItem( Batch.find( batch.getId() ) );
			
		incrementDone();
	}
}
