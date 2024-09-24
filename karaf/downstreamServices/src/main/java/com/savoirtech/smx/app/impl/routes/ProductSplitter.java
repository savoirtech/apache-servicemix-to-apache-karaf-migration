/*****************
 * (C) Copyright 2015 - Savoir Technologies Inc, Jeff Genender
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savoirtech.smx.app.impl.routes;

import com.savoirtech.smx.app.models.Item;
import com.savoirtech.smx.app.models.Order;
import com.savoirtech.smx.app.models.ProductOrder;
import org.apache.camel.CamelContext;
import org.apache.camel.Message;
import org.apache.camel.support.DefaultMessage; //Package change on Camel 3.

import java.util.ArrayList;
import java.util.List;

public class ProductSplitter {

    private CamelContext camelContext;

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public List<Message> splitProducts(Order order){

        List<Message> messages = new ArrayList<Message>();

        for(Item item : order.getItems()){

            ProductOrder po = new ProductOrder();
            po.setCustomer(order.getCustomer());
            po.setProduct(item.getProduct());
            po.setQuanitity(item.getQuantity());

            DefaultMessage message = new DefaultMessage(camelContext);
            message.setBody(po);

            //Set the header with the manufacturer
            if (item.getProduct().startsWith("abc")) {
                message.setHeader("manufacturer", "abc");
            } else if(item.getProduct().startsWith("xyz")) {
                message.setHeader("manufacturer", "xyz");
            }

            messages.add(message);

        }

        return messages;
    }

}
