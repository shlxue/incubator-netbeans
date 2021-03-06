/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.libs.git.jgit.commands;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.jgit.lib.Repository;
import org.netbeans.libs.git.jgit.GitClassFactory;
import org.netbeans.libs.git.jgit.Utils;
import org.netbeans.libs.git.progress.ProgressMonitor;

/**
 * @author ondra
 */
public class ListRemoteTagsCommand extends ListRemoteObjectsCommand {
    private Map<String, String> remoteTags;
    private final String remoteUrl;

    public ListRemoteTagsCommand (Repository repository, GitClassFactory gitFactory, String remoteRepositoryUrl, ProgressMonitor monitor) {
        super(repository, gitFactory, remoteRepositoryUrl, monitor);
        this.remoteUrl = remoteRepositoryUrl;
    }

    @Override
    protected void processRefs () {
        remoteTags = new LinkedHashMap<String, String>();
        remoteTags.putAll(Utils.refsToTags(getRefs()));
    }

    @Override
    protected String getCommandDescription () {
        return "git ls-remote --heads " + remoteUrl.toString(); //NOI18N
    }

    public Map<String, String> getTags () {
        return remoteTags;
    }

}
