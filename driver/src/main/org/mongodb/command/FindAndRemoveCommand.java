/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mongodb.command;

import org.mongodb.CommandDocument;
import org.mongodb.MongoCollection;
import org.mongodb.operation.MongoCommand;
import org.mongodb.operation.MongoFindAndModify;
import org.mongodb.serialization.PrimitiveSerializers;
import org.mongodb.serialization.Serializer;

public class FindAndRemoveCommand<T> extends FindAndModifyCommand<T> {
    public FindAndRemoveCommand(final MongoCollection<T> collection,
                                final MongoFindAndModify findAndModify, final PrimitiveSerializers primitiveSerializers,
                                final Serializer<T> serializer) {
        super(collection, findAndModify, primitiveSerializers, serializer);
    }

    @Override
    public MongoCommand asMongoCommand() {
        final CommandDocument cmd = getBaseCommandDocument();
        cmd.put("remove", true);
        return cmd;
    }
}