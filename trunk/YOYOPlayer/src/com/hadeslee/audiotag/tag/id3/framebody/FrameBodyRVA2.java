/**
 *  @author : Paul Taylor
 *  @author : Eric Farng
 *
 *  Version @version:$Id: FrameBodyRVA2.java,v 1.10 2007/08/06 16:04:34 paultaylor Exp $
 *
 *  MusicTag Copyright (C)2003,2004
 *
 *  This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 *  General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 *  or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 *  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 *  you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Description:
 * Relative Volume Adjustment
 *
 */
package com.hadeslee.audiotag.tag.id3.framebody;

import com.hadeslee.audiotag.tag.InvalidTagException;
import com.hadeslee.audiotag.tag.datatype.ByteArraySizeTerminated;
import com.hadeslee.audiotag.tag.datatype.DataTypes;
import com.hadeslee.audiotag.tag.id3.ID3v24Frames;

import java.nio.ByteBuffer;

public class FrameBodyRVA2 extends AbstractID3v2FrameBody implements ID3v24FrameBody
{

    /**
     * Creates a new FrameBodyRVA2 datatype.
     */
    public FrameBodyRVA2()
    {
    }

    public FrameBodyRVA2(FrameBodyRVA2 body)
    {
        super(body);
    }

    /**
     * Convert from V3 to V4 Frame
     */
    public FrameBodyRVA2(FrameBodyRVAD body)
    {
        setObjectValue(DataTypes.OBJ_DATA, body.getObjectValue(DataTypes.OBJ_DATA));
    }


    /**
     * Creates a new FrameBodyRVAD datatype.
     *
     * @throws InvalidTagException if unable to create framebody from buffer
     */
    public FrameBodyRVA2(ByteBuffer byteBuffer, int frameSize)
        throws InvalidTagException
    {
        super(byteBuffer, frameSize);
    }

        /**
      * The ID3v2 frame identifier
      *
      * @return the ID3v2 frame identifier  for this frame type
     */
    public String getIdentifier()
    {
        return ID3v24Frames.FRAME_ID_RELATIVE_VOLUME_ADJUSTMENT2;
    }

    /**
     * Setup the Object List. A byte Array which will be read upto frame size
     * bytes.
     */
    protected void setupObjectList()
    {
        objectList.add(new ByteArraySizeTerminated(DataTypes.OBJ_DATA, this));
    }


}
