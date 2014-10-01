/**********************************************************************
Copyright (c) 2009 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.api.jdo.metadata;

import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.metadata.ColumnMetadata;
import javax.jdo.metadata.EmbeddedMetadata;
import javax.jdo.metadata.ForeignKeyMetadata;
import javax.jdo.metadata.IndexMetadata;
import javax.jdo.metadata.UniqueMetadata;
import javax.jdo.metadata.ValueMetadata;

import org.datanucleus.metadata.ColumnMetaData;
import org.datanucleus.metadata.EmbeddedMetaData;
import org.datanucleus.metadata.ForeignKeyMetaData;
import org.datanucleus.metadata.IndexMetaData;
import org.datanucleus.metadata.UniqueMetaData;
import org.datanucleus.metadata.ValueMetaData;

/**
 * Implementation of JDO ValueMetadata object.
 */
public class ValueMetadataImpl extends AbstractMetadataImpl implements ValueMetadata
{
    public ValueMetadataImpl(ValueMetaData internal)
    {
        super(internal);
    }

    public ValueMetaData getInternal()
    {
        return (ValueMetaData)internalMD;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getColumn()
     */
    public String getColumn()
    {
        return getInternal().getColumnName();
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.KeyMetadata#getColumns()
     */
    public ColumnMetadata[] getColumns()
    {
        ColumnMetaData[] internalColmds = getInternal().getColumnMetaData();
        if (internalColmds == null)
        {
            return null;
        }
        ColumnMetadataImpl[] colmds = new ColumnMetadataImpl[internalColmds.length];
        for (int i=0;i<colmds.length;i++)
        {
            colmds[i] = new ColumnMetadataImpl(internalColmds[i]);
            colmds[i].parent = this;
        }
        return colmds;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#setColumn(java.lang.String)
     */
    public ValueMetadata setColumn(String name)
    {
        getInternal().setColumnName(name);
        return this;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.KeyMetadata#newColumnMetadata()
     */
    public ColumnMetadata newColumnMetadata()
    {
        ColumnMetaData internalColmd = getInternal().newColumnMetaData();
        ColumnMetadataImpl colmd = new ColumnMetadataImpl(internalColmd);
        colmd.parent = this;
        return colmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getDeleteAction()
     */
    public ForeignKeyAction getDeleteAction()
    {
        org.datanucleus.metadata.ForeignKeyAction fk = getInternal().getDeleteAction();
        if (fk == org.datanucleus.metadata.ForeignKeyAction.CASCADE)
        {
            return ForeignKeyAction.CASCADE;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.DEFAULT)
        {
            return ForeignKeyAction.DEFAULT;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.NONE)
        {
            return ForeignKeyAction.NONE;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.NULL)
        {
            return ForeignKeyAction.NULL;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.RESTRICT)
        {
            return ForeignKeyAction.RESTRICT;
        }
        return ForeignKeyAction.UNSPECIFIED;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#setDeleteAction(javax.jdo.annotations.ForeignKeyAction)
     */
    public ValueMetadata setDeleteAction(ForeignKeyAction fk)
    {
        if (fk == ForeignKeyAction.CASCADE)
        {
            getInternal().setDeleteAction(org.datanucleus.metadata.ForeignKeyAction.CASCADE);
        }
        else if (fk == ForeignKeyAction.DEFAULT)
        {
            getInternal().setDeleteAction(org.datanucleus.metadata.ForeignKeyAction.DEFAULT);
        }
        else if (fk == ForeignKeyAction.NONE)
        {
            getInternal().setDeleteAction(org.datanucleus.metadata.ForeignKeyAction.NONE);
        }
        else if (fk == ForeignKeyAction.NULL)
        {
            getInternal().setDeleteAction(org.datanucleus.metadata.ForeignKeyAction.NULL);
        }
        else if (fk == ForeignKeyAction.RESTRICT)
        {
            getInternal().setDeleteAction(org.datanucleus.metadata.ForeignKeyAction.RESTRICT);
        }
        return this;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getUpdateAction()
     */
    public ForeignKeyAction getUpdateAction()
    {
        org.datanucleus.metadata.ForeignKeyAction fk = getInternal().getUpdateAction();
        if (fk == org.datanucleus.metadata.ForeignKeyAction.CASCADE)
        {
            return ForeignKeyAction.CASCADE;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.DEFAULT)
        {
            return ForeignKeyAction.DEFAULT;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.NONE)
        {
            return ForeignKeyAction.NONE;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.NULL)
        {
            return ForeignKeyAction.NULL;
        }
        else if (fk == org.datanucleus.metadata.ForeignKeyAction.RESTRICT)
        {
            return ForeignKeyAction.RESTRICT;
        }
        return ForeignKeyAction.UNSPECIFIED;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#setUpdateAction(javax.jdo.annotations.ForeignKeyAction)
     */
    public ValueMetadata setUpdateAction(ForeignKeyAction fk)
    {
        if (fk == ForeignKeyAction.CASCADE)
        {
            getInternal().setUpdateAction(org.datanucleus.metadata.ForeignKeyAction.CASCADE);
        }
        else if (fk == ForeignKeyAction.DEFAULT)
        {
            getInternal().setUpdateAction(org.datanucleus.metadata.ForeignKeyAction.DEFAULT);
        }
        else if (fk == ForeignKeyAction.NONE)
        {
            getInternal().setUpdateAction(org.datanucleus.metadata.ForeignKeyAction.NONE);
        }
        else if (fk == ForeignKeyAction.NULL)
        {
            getInternal().setUpdateAction(org.datanucleus.metadata.ForeignKeyAction.NULL);
        }
        else if (fk == ForeignKeyAction.RESTRICT)
        {
            getInternal().setUpdateAction(org.datanucleus.metadata.ForeignKeyAction.RESTRICT);
        }
        return this;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getForeignKeyMetadata()
     */
    public ForeignKeyMetadata getForeignKeyMetadata()
    {
        ForeignKeyMetaData internalFkmd = getInternal().getForeignKeyMetaData();
        if (internalFkmd == null)
        {
            return null;
        }
        ForeignKeyMetadataImpl fkmd = new ForeignKeyMetadataImpl(internalFkmd);
        fkmd.parent = this;
        return fkmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#newForeignKeyMetadata()
     */
    public ForeignKeyMetadata newForeignKeyMetadata()
    {
        ForeignKeyMetaData internalFkmd = getInternal().newForeignKeyMetaData();
        ForeignKeyMetadataImpl fkmd = new ForeignKeyMetadataImpl(internalFkmd);
        fkmd.parent = this;
        return fkmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getUniqueMetadata()
     */
    public UniqueMetadata getUniqueMetadata()
    {
        UniqueMetaData internalUnimd = getInternal().getUniqueMetaData();
        if (internalUnimd == null)
        {
            return null;
        }
        UniqueMetadataImpl unimd = new UniqueMetadataImpl(internalUnimd);
        unimd.parent = this;
        return unimd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#newUniqueMetadata()
     */
    public UniqueMetadata newUniqueMetadata()
    {
        UniqueMetaData internalUnimd = getInternal().newUniqueMetaData();
        UniqueMetadataImpl unimd = new UniqueMetadataImpl(internalUnimd);
        unimd.parent = this;
        return unimd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getIndexMetadata()
     */
    public IndexMetadata getIndexMetadata()
    {
        IndexMetaData internalIdxmd = getInternal().getIndexMetaData();
        if (internalIdxmd == null)
        {
            return null;
        }
        IndexMetadataImpl idxmd = new IndexMetadataImpl(internalIdxmd);
        idxmd.parent = this;
        return idxmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#newIndexMetadata()
     */
    public IndexMetadata newIndexMetadata()
    {
        IndexMetaData internalIdxmd = getInternal().newIndexMetaData();
        IndexMetadataImpl idxmd = new IndexMetadataImpl(internalIdxmd);
        idxmd.parent = this;
        return idxmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getEmbeddedMetadata()
     */
    public EmbeddedMetadata getEmbeddedMetadata()
    {
        EmbeddedMetaData internalEmbmd = getInternal().getEmbeddedMetaData();
        if (internalEmbmd == null)
        {
            return null;
        }
        EmbeddedMetadataImpl embmd = new EmbeddedMetadataImpl(internalEmbmd);
        embmd.parent = this;
        return embmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#newEmbeddedMetadata()
     */
    public EmbeddedMetadata newEmbeddedMetadata()
    {
        EmbeddedMetaData internalEmbmd = getInternal().newEmbeddedMetaData();
        EmbeddedMetadataImpl embmd = new EmbeddedMetadataImpl(internalEmbmd);
        embmd.parent = this;
        return embmd;
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#getTable()
     */
    public String getTable()
    {
        return getInternal().getTable();
    }

    /* (non-Javadoc)
     * @see javax.jdo.metadata.ValueMetadata#setTable(java.lang.String)
     */
    public ValueMetadata setTable(String name)
    {
        getInternal().setTable(name);
        return this;
    }
}