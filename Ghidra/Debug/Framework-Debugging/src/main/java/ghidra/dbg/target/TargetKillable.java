/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.dbg.target;

import java.util.concurrent.CompletableFuture;

import ghidra.dbg.DebuggerTargetObjectIface;

@DebuggerTargetObjectIface("Killable")
public interface TargetKillable<T extends TargetKillable<T>> extends TypedTargetObject<T> {
	enum Private {
		;
		private abstract class Cls implements TargetKillable<Cls> {
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	Class<Private.Cls> tclass = (Class) TargetKillable.class;

	/**
	 * Kill this target
	 * 
	 * @return a future which completes upon successfully terminating the target
	 */
	public CompletableFuture<Void> kill();
}