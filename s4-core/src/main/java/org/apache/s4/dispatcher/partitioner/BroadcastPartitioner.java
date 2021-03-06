/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.s4.dispatcher.partitioner;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition events to be sent to all parts. This can be used in conjunction
 * with a Dispatcher to broadcast events.
 */
public class BroadcastPartitioner implements Partitioner {
    @Override
    public List<CompoundKeyInfo> partition(String streamName, Object event,
                                           int partitionCount) {

        List<CompoundKeyInfo> partitionInfoList = new ArrayList<CompoundKeyInfo>();

        // assign to all partitions
        for (int i = 0; i < partitionCount; ++i) {
            CompoundKeyInfo partitionInfo = new CompoundKeyInfo();

            partitionInfo.setPartitionId(i);

            partitionInfoList.add(partitionInfo);
        }

        return partitionInfoList;
    }
}
