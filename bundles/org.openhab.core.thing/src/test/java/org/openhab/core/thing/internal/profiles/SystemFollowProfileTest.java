/**
 * Copyright (c) 2010-2022 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.core.thing.internal.profiles;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.thing.profiles.ProfileCallback;

/**
 *
 * @author Simon Kaufmann - Initial contribution
 */
@ExtendWith(MockitoExtension.class)
@NonNullByDefault
public class SystemFollowProfileTest {

    private @Mock @NonNullByDefault({}) ProfileCallback callbackMock;

    @Test
    public void testOnCommand() {
        SystemFollowProfile profile = new SystemFollowProfile(callbackMock);

        profile.onCommandFromItem(OnOffType.ON);

        verifyNoMoreInteractions(callbackMock);
    }

    @Test
    public void testOnUpdate() {
        SystemFollowProfile profile = new SystemFollowProfile(callbackMock);
        profile.onStateUpdateFromItem(OnOffType.ON);

        verify(callbackMock).handleCommand(eq(OnOffType.ON));
        verifyNoMoreInteractions(callbackMock);
    }

    @Test
    public void testStateUpdated() {
        SystemFollowProfile profile = new SystemFollowProfile(callbackMock);
        profile.onStateUpdateFromHandler(OnOffType.ON);

        verifyNoMoreInteractions(callbackMock);
    }

    @Test
    public void testPostCommand() {
        SystemFollowProfile profile = new SystemFollowProfile(callbackMock);
        profile.onCommandFromHandler(OnOffType.ON);

        verify(callbackMock).sendCommand(eq(OnOffType.ON));
        verifyNoMoreInteractions(callbackMock);
    }
}
